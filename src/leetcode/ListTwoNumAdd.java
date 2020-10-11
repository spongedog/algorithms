package leetcode;

/**
 * 2两数相加
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/10
 */
public class ListTwoNumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int step;
        if (sum >= 10) {
            step = 1;
            sum %= 10;
        } else {
            step = 0;
        }

        ListNode first = new ListNode(sum);
        ListNode last = first;
        while (l1.next != null && l2.next != null) {
            sum = l1.next.val + l2.next.val + step;
            if (sum >= 10) {
                step = 1;
                sum %= 10;
            } else {
                step = 0;
            }
            ListNode sumNode = new ListNode(sum);
            last.next = sumNode;
            last = sumNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        //todo 进位处理
        if (l1.next != null) {
            last.next = l1.next;
        } else if (l2.next != null) {
            last.next = l2.next;
        }

        return first;
    }
}
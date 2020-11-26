package leetcode;

import java.util.Optional;

/**
 * 2两数相加
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/10
 */
public class ListTwoNumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode last = first;
        int step = 0;
        while (l1 != null || l2 != null) {
            int sum = Optional.ofNullable(l1).map(l -> l.val).orElse(0) +
                    Optional.ofNullable(l2).map(l -> l.val).orElse(0)
                    + step;
            step = sum / 10;
            sum %= 10;
            ListNode sumNode = new ListNode(sum);
            last.next = sumNode;
            last = sumNode;
            l1 = Optional.ofNullable(l1).map(l -> l.next).orElse(null);
            l2 = Optional.ofNullable(l2).map(l -> l.next).orElse(null);
        }

        if (step > 0) {
            last.next = new ListNode(step);
        }

        return first.next;
    }
}
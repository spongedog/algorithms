package leetcode;

/**
 * 141环形链表
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/10
 */
public class RingList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

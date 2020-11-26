package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/10
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void visit() {
        System.out.println(val +" ");
        if (next != null) {
            next.visit();
        }
    }
}


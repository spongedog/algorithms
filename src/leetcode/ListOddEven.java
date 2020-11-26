package leetcode;

import java.util.Scanner;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/13
 */
public class ListOddEven {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        ListNode current = head.next.next;
        boolean odd = true;
        while (current != null) {
            if (odd) {
                oddNode.next = current;
                oddNode = current;
                odd = false;
            } else {
                evenNode.next = current;
                evenNode = current;
                odd = true;
            }
            current = current.next;
        }
        evenNode.next = null;
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode node = new ListNode(scanner.nextInt());
        ListNode head = node;
        while (scanner.hasNextInt()){
            int val = scanner.nextInt();
            if (val == -1) {
                break;
            }
            node.next = new ListNode(val);
            node = node.next;
        }

        oddEvenList(head);
        head.visit();
    }
}

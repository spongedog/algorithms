package dynamic;

/**
 * 反转链表
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/19
 */
public class MyLinkedList {

    private Node head;

    class Node {
       private int value;

       private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void add(Integer value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
             while (last.next != null) {
                last = last.next;
             }
             last.next = node;
        }
    }

    public void reverse() {
        head = reverse(head);
    }

    private Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }

        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public void reverse2() {
        while (head.next != null) {
            Node pre = head;
            head.next.next = head;
            head = head.next;
            pre.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node !=null) {
            sb.append(node.value).append(",");
            node = node.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add(2);
        myList.add(5);
        myList.add(3);
        myList.add(7);

        myList.reverse();
        System.out.println(myList);

        myList.reverse();
        System.out.println(myList);
    }
}



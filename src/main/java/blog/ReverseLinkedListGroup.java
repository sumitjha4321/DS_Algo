package blog;

/**
 * Created by sumit.jha on 01/11/18.
 */
public class ReverseLinkedListGroup {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    void print(Node head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }

    Node reverse(Node head, int k) {
        Node prev = null, next = null, curr = head;
        int n = k;
        while (n > 0 && curr != null) {
            n--;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (curr != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

    public static void main(String[] args) {

        ReverseLinkedListGroup linkedList = new ReverseLinkedListGroup();
        linkedList.head = new Node(10);
        linkedList.head.next = new Node(20);
        linkedList.head.next.next = new Node(30);
        linkedList.head.next.next.next = new Node(40);
        linkedList.head.next.next.next.next = new Node(50);
        linkedList.head.next.next.next.next.next = new Node(60);
        linkedList.head.next.next.next.next.next.next = new Node(70);
        linkedList.head.next.next.next.next.next.next.next = new Node(80);

        linkedList.print(linkedList.head);

        linkedList.head = linkedList.reverse(linkedList.head, 3);
        linkedList.print(linkedList.head);


    }
}

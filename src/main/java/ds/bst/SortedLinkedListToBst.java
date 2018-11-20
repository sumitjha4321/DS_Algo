package ds.bst;

/**
 * Created by sumit.jha on 28/06/18.
 */
public class SortedLinkedListToBst {

    static class LNode {
        int data;
        LNode next;
        LNode prev;

        public LNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    LNode head;

    LNode addToList(LNode head, int val) {
        if (head == null) {
            head = new LNode(val);
            return head;
        }
        head.next = addToList(head.next, val);
        head.next.prev = head;
        return head;
    }

    int getLSize(LNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }

    void traverse(LNode head) {
        while (head.next != null) {
            head = head.next;
        }
        while (head != null) {
            System.out.println(head.data);
            head = head.prev;
        }
    }


    LNode convertToBst(int n) {
        if (n <= 0) {
            return null;
        }
        LNode left = convertToBst(n / 2);
        LNode root = head;
        root.prev = left;
        head = head.next;
        root.next = convertToBst(n - n / 2 - 1);
        return root;
    }

    LNode treeNode;

    void inorder(LNode root) {
        if (root == null) {
            return;
        }
        inorder(root.prev);
        System.out.print(root.data);
        inorder(root.next);
    }

    public static void main(String[] args) {
        SortedLinkedListToBst sortedLinkedListToBst = new SortedLinkedListToBst();

        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 1);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 2);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 3);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 4);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 5);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 6);
        sortedLinkedListToBst.head = sortedLinkedListToBst.addToList(sortedLinkedListToBst.head, 7);

        //sortedLinkedListToBst.traverse(sortedLinkedListToBst.head);

        sortedLinkedListToBst.treeNode = sortedLinkedListToBst.convertToBst(7);

        sortedLinkedListToBst.inorder(sortedLinkedListToBst.treeNode);


    }
}

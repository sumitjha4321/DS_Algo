package prep.ds.tree;

/**
 * Created by sumit.jha on 11/10/18.
 */
public class SortedArrayToBST {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;
    private Node head;

    static class LLNode {
        int val;
        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }
    }

    private int getKthNode(LLNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head.val;
    }

    public Node createBST(Node root, LLNode head, int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        root = new Node(getKthNode(head, mid));
        root.left = createBST(root.left, head, arr, start, mid - 1);
        root.right = createBST(root.right, head, arr, mid + 1, end);

        return root;

    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + "  ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {25, 50, 60, 70, 80, 100, 200};
        LLNode head = new LLNode(25);
        head.next = new LLNode(50);
        head.next.next = new LLNode(60);
        head.next.next.next = new LLNode(70);
        head.next.next.next.next = new LLNode(80);
        head.next.next.next.next.next = new LLNode(100);
        head.next.next.next.next.next.next = new LLNode(200);


        SortedArrayToBST bst = new SortedArrayToBST();
        bst.root = bst.createBST(bst.root, head , arr, 0, arr.length - 1);

        bst.inorder(bst.root);


    }
}

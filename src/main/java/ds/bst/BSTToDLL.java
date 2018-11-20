package ds.bst;

/**
 * Created by sumit.jha on 28/06/18.
 */
public class BSTToDLL {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    Node head = null, prev = null;

    private void convertToDll(Node root) {
        if (root == null) {
            return;
        }
        convertToDll(root.left);
        if (head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertToDll(root.right);
    }

    private void traverseDll() {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BSTToDLL bstToDLL = new BSTToDLL();

        bstToDLL.root = new Node(15);
        bstToDLL.root.left = new Node(10);
        bstToDLL.root.right = new Node(20);
        bstToDLL.root.left.left = new Node(8);
        bstToDLL.root.left.right = new Node(12);
        bstToDLL.root.right.left = new Node(16);
        bstToDLL.root.right.right = new Node(25);

        bstToDLL.convertToDll(bstToDLL.root);
        bstToDLL.traverseDll();


    }

}

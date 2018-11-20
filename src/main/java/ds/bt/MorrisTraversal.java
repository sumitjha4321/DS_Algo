package ds.bt;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class MorrisTraversal {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    private Node findPred(Node node, int val) {
        node = node.left;
        while (node.right != null && node.right.val != val) {
            node = node.right;
        }
        return node;
    }

    void traverse(Node root) {
        while (root != null) {
            if (root.left == null) {
                System.out.println(root.val);
                root = root.right;
            } else {
                Node pred = findPred(root, root.val);
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    System.out.println(root.val);
                    root = root.right;
                    pred.right = null;
                }
            }
        }
    }

    public static void main(String[] args) {

        MorrisTraversal morrisTraversal = new MorrisTraversal();

        morrisTraversal.root = new Node(10);
        morrisTraversal.root.left = new Node(5);
        morrisTraversal.root.right = new Node(20);
        morrisTraversal.root.left.left = new Node(3);
        morrisTraversal.root.left.right = new Node(6);

        morrisTraversal.traverse(morrisTraversal.root);


    }
}

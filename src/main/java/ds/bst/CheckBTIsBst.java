package ds.bst;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class CheckBTIsBst {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    private boolean isBst(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) return false;
        return isBst(node.left, min, node.val) && isBst(node.right, node.val, max);
    }

    public static void main(String[] args) {
        CheckBTIsBst checkBst = new CheckBTIsBst();
        checkBst.root = new Node(20);
        checkBst.root.left = new Node(10);
        checkBst.root.right = new Node(30);
        checkBst.root.left.left = new Node(5);
        checkBst.root.left.right = new Node(18);
        checkBst.root.right.left = new Node(22);
        checkBst.root.right.right = new Node(40);

        System.out.println(checkBst.isBst(checkBst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));


    }


}

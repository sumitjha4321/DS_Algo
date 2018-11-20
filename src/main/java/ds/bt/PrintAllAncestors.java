package ds.bt;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class PrintAllAncestors {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    boolean flag = false;
    Node root;

    private void print(Node root, int val) {
        if (root == null) return;
        if (root.val == val) {
            flag = true;
            return;
        }
        if (!flag) print(root.left, val);
        if (!flag) print(root.right, val);
        if (flag) System.out.println(root.val);
    }

    private boolean print2(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }

        if (print2(root.left, val) || print2(root.right, val)) {
            System.out.println(root.val);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        PrintAllAncestors printAllAncestors = new PrintAllAncestors();

        printAllAncestors.root = new Node(1);
        printAllAncestors.root.left = new Node(2);
        printAllAncestors.root.right = new Node(3);
        printAllAncestors.root.left.left = new Node(4);
        printAllAncestors.root.left.right = new Node(5);
        printAllAncestors.root.left.left.left = new Node(7);

        printAllAncestors.print(printAllAncestors.root, 5);


    }
}

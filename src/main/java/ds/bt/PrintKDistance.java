package ds.bt;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class PrintKDistance {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    private void print(Node root, int K) {
        if (root == null) return;
        if (K == 0) {
            System.out.println(root.val);
            return;
        }
        print(root.left, K - 1);
        print(root.right, K - 1);
    }

    public static void main(String[] args) {
        PrintKDistance printKDistance = new PrintKDistance();

        printKDistance.root = new Node(1);
        printKDistance.root.left = new Node(2);
        printKDistance.root.right = new Node(3);
        printKDistance.root.left.left = new Node(4);
        printKDistance.root.left.right = new Node(5);
        printKDistance.root.right.right = new Node(8);
        printKDistance.root.right.right.left = new Node(6);
        printKDistance.root.right.right.right = new Node(7);

        printKDistance.print(printKDistance.root, 2);



    }

}

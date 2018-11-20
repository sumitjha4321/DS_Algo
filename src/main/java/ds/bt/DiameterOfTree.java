package ds.bt;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class DiameterOfTree {


    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    public DiameterOfTree() {
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(height(root.left), height(root.right)));
    }

    private int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        return max(1 + height(root.left) + height(root.right), diameter(root.left), diameter(root.right));
    }
    private static class Height{
        int h;
    }

    private int diameterOptimised(Node root, Height height) {
        if (root == null) {
            height.h = 0; 
            return 0;
        }
        Height lh = new Height();
        Height rh = new Height();

        int ld = diameterOptimised(root.left, lh);
        int rd = diameterOptimised(root.right, rh);
        return max(1 + lh.h + rh.h, diameter(root.left), diameter(root.right));
    }

    public static void main(String[] args) {
        DiameterOfTree tree = new DiameterOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.diameter(tree.root));


    }

}

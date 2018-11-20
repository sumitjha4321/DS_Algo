package prep.ds.tree;

/**
 * Created by sumit.jha on 09/10/18.
 */
public class DiameterBT {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public Node root;

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static class Height {
        int h;
    }

    private int getDiameter(Node root, Height height) {
        if (root == null) {
            height.h = 0;
            return 0;
        }
        Height left = new Height();
        Height right = new Height();

        int ld = getDiameter(root.left, left);
        int rd = getDiameter(root.right, right);

        height.h = 1 + Math.max(left.h, right.h);


        return Math.max(1 + left.h + right.h, Math.max(ld, rd));
    }


}

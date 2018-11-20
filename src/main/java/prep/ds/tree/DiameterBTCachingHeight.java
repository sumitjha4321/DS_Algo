package prep.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumit.jha on 09/10/18.
 */
public class DiameterBTCachingHeight {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public Node root;

    public DiameterBTCachingHeight() {
        map = new HashMap<>();
    }
    private Map<Node, Integer> map;

    private int height(Node root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        else {
            int height = 1 + Math.max(height(root.left), height(root.right));
            map.put(root, height);
            return height;
        }
    }

    private int getDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diameter = 1 + height(root.left) + height(root.right);
        return Math.max(diameter, Math.max(getDiameter(root.left), getDiameter(root.right)));
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + "  ");
        inorder(root.right);

    }

    public static void main(String[] args) {
        DiameterBTCachingHeight diameterBT = new DiameterBTCachingHeight();
        diameterBT.root = new Node(1);

        diameterBT.root.left = new Node(2);
        diameterBT.root.right = new Node(3);

        diameterBT.root.left.left = new Node(4);
        diameterBT.root.left.right = new Node(5);

        diameterBT.root.left.left.left = new Node(6);
        diameterBT.root.left.left.right = new Node(7);
        diameterBT.root.left.right.left = new Node(8);
        diameterBT.root.left.right.right = new Node(9);

        diameterBT.root.left.right.left.left = new Node(10);


        //diameterBT.inorder(diameterBT.root);
        System.out.println(diameterBT.getDiameter(diameterBT.root));


    }
}

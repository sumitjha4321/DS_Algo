package ds.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class MaxWidth {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private int getWidthAtLevel(Node root, int level) {
        if (root == null) {
            return 0;
        }
        if (level == 1) return 1;
        return getWidthAtLevel(root.left, level - 1) + getWidthAtLevel(root.right, level - 1);
    }

    private int getMaxWidth(Node root) {
        int h = height(root);
        int ans = 0;
        for (int i = 1; i <= h; i++) {
            ans = Math.max(ans, getWidthAtLevel(root, i));
        }
        return ans;
    }

    private int getMaxWidthQueueBased(Node root) {
        List<Node> list = new ArrayList<>();
        list.add(root);
        int ans = 0;
        while (!list.isEmpty()) {
            int count = list.size();
            ans = Math.max(ans, count);
            while (count-- > 0) {
                Node node = list.remove(0);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        MaxWidth maxWidth = new MaxWidth();
        maxWidth.root = new Node(1);
        maxWidth.root.left = new Node(2);
        maxWidth.root.right = new Node(3);
        maxWidth.root.left.left = new Node(4);
        maxWidth.root.left.right = new Node(5);
        maxWidth.root.right.right = new Node(8);
        maxWidth.root.right.right.left = new Node(6);
        maxWidth.root.right.right.right = new Node(7);

        System.out.println(maxWidth.getMaxWidthQueueBased(maxWidth.root));


    }
}

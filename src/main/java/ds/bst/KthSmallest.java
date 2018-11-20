package ds.bst;

import java.util.Stack;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class KthSmallest {
    static class Node {
        int val;
        Node left, right;
        int h;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private int init(Node root) {
        if (root == null) {
            return 0;
        }
        root.h = 1 + init(root.left) + init(root.right);

        return root.h;
    }

    Node root;

    /*private int getKthSmallest(Node root, int K) {
        if (root == null) {
            return 0;
        }
        if (1 + (root.left == null ? 0 : root.left.h) == K) {
            return root.val;
        }
        if (1 + (root.left == null ? 0 : root.left.h) > K) {
            return getKthSmallest(root.left, K);
        }
        return getKthSmallest(root.right, K - 1 - (root.left == null ? 0 : root.left.h));
    }*/


    private void getKthSmallest(Node root, int K) {
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            K--;
            if (K == 0) {
                System.out.println(root.val);
                return;
            }
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }

        }
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();

        kthSmallest.root = new Node(20);
        kthSmallest.root.left = new Node(10);
        kthSmallest.root.right = new Node(30);
        kthSmallest.root.left.left = new Node(5);
        kthSmallest.root.left.right = new Node(18);
        kthSmallest.root.right.left = new Node(22);
        kthSmallest.root.right.right = new Node(40);

        kthSmallest.init(kthSmallest.root);
        kthSmallest.getKthSmallest(kthSmallest.root, 3);


    }
}

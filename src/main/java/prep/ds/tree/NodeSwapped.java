package prep.ds.tree;

import java.util.*;

/**
 * Created by sumit.jha on 10/10/18.
 */
public class NodeSwapped {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    private Node pred, prev, curr, next;

    private void fixBSTUtil(Node root) {
        if (root == null) return;
        fixBSTUtil(root.left);
        if (pred != null && pred.val > root.val) {
            if (prev == null) {
                prev = pred;
                curr = root;
            } else {
                next = root;
            }
        }
        pred = root;
        fixBSTUtil(root.right);
    }


    private boolean inorder(Node root1, Node root2, int sum) throws Exception {
        Stack<Node> first = new Stack<>();
        Stack<Node> second = new Stack<>();

        first.add(root1);
        second.add(root2);

        root1 = root1.left;
        root2 = root2.right;
        while (!first.isEmpty() && !second.isEmpty()) {

            while (root1 != null) {
                first.add(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                second.add(root2);
                root2 = root2.right;
            }

            Node top1 = first.peek();
            Node top2 = second.peek();

            if (sum == top1.val + top2.val) {
                return true;
            } else if (sum > top1.val + top2.val) {
                root1 = first.pop().right;
            } else {
                root2 = second.pop().left;
            }
        }
        throw new Exception("Pair with given sum not found");
    }

    public static void main(String[] args) {

        NodeSwapped bst = new NodeSwapped();

        bst.root = new Node(100);
        bst.root.left = new Node(50);
        bst.root.right = new Node(200);
        bst.root.left.left = new Node(25);
        bst.root.left.right = new Node(70);
        bst.root.left.right.left = new Node(60);
        bst.root.left.right.right = new Node(80);

        bst.root.right.right = new Node(300);
        bst.root.right.right.right = new Node(400);



    }

}

package ds.bt;

import java.util.Stack;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class InorderWithoutRecursion {
    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    void inorderWithoutStack(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

    }

    public static void main(String[] args) {
        InorderWithoutRecursion inorderWithoutRecursion = new InorderWithoutRecursion();

        inorderWithoutRecursion.root = new Node(1);
        inorderWithoutRecursion.root.left = new Node(2);
        inorderWithoutRecursion.root.right = new Node(3);
        inorderWithoutRecursion.root.left.left = new Node(4);
        inorderWithoutRecursion.root.left.right = new Node(5);

        inorderWithoutRecursion.inorderWithoutStack(inorderWithoutRecursion.root);


    }
}

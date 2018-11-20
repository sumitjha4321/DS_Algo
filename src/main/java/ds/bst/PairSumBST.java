package ds.bst;

import java.util.Stack;

/**
 * Created by sumit.jha on 28/06/18.
 */
public class PairSumBST {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    Node root;

    void printPairs(Node rootMin, Node rootMax, int sum) {
        Stack<Node> min = new Stack<>();
        Stack<Node> max = new Stack<>();
        while (rootMin != null) {
            min.push(rootMin);
            rootMin = rootMin.left;
        }
        while (rootMax != null) {
            max.push(rootMax);
            rootMax = rootMax.right;
        }
        while (!min.isEmpty() && !max.isEmpty()) {
            int low = min.peek().val;
            int high = max.peek().val;

            if (low + high == sum) {
                System.out.println("Found: " + low + ", " + high);
                return;
            } else if (low + high < sum) {
                Node minNode = min.pop();
                if (minNode.right != null) {
                    rootMin = minNode.right;
                }
            } else {
                Node maxNode = max.pop();
                if (maxNode.left != null) {
                    rootMax = maxNode.left;
                }
            }
            while (rootMin != null) {
                min.push(rootMin);
                rootMin = rootMin.left;
            }
            while (rootMax != null) {
                max.push(rootMax);
                rootMax = rootMax.right;
            }
        }

    }

    public static void main(String[] args) {
        PairSumBST pairSumBST = new PairSumBST();
        pairSumBST.root = new Node(15);
        pairSumBST.root.left = new Node(10);
        pairSumBST.root.right = new Node(20);
        pairSumBST.root.left.left = new Node(8);
        pairSumBST.root.left.right = new Node(12);
        pairSumBST.root.right.left = new Node(16);
        pairSumBST.root.right.right = new Node(25);

        pairSumBST.printPairs(pairSumBST.root, pairSumBST.root, 40);


    }

}

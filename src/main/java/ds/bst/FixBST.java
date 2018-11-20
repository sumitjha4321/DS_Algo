package ds.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumit.jha on 28/06/18.
 */
public class FixBST {
    static class Node {
        int val;
        Node left, right;
        int h;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    List<Node> list = new ArrayList<>();

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + "  ");
        list.add(root);
        inorder(root.right);
    }

    Node first = null, middle = null, last = null;
    Node prev = null;

    void inorderOptimised(Node root) {
        if (root == null) {
            return;
        }
        inorderOptimised(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorderOptimised(root.right);
    }


    public static void main(String[] args) {
        FixBST fixBST = new FixBST();

        fixBST.root = new Node(10);
        fixBST.root.left = new Node(5);
        fixBST.root.right = new Node(8);
        fixBST.root.left.left = new Node(2);
        fixBST.root.left.right = new Node(20);

        /*
        SOL-1 : STORE INORDER IN ARRAY AND CHECK
        Node first = null, middle = null, last = null;
        fixBST.inorder(fixBST.root);
        System.out.println();
        for (int i = 0; i < fixBST.list.size() - 1; i++) {
            if (fixBST.list.get(i).val > fixBST.list.get(i + 1).val) {
                if (first == null) {
                    first = fixBST.list.get(i);
                    middle = fixBST.list.get(i + 1);
                } else {
                    last = fixBST.list.get(i + 1);
                }
            }
        }
        if (last == null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        } else {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }

        fixBST.inorder(fixBST.root);
        */

        // SOL-2: CHECK WHILE TRAVERSING ONLY

        fixBST.inorder(fixBST.root);
        System.out.println();
        fixBST.inorderOptimised(fixBST.root);

        if (fixBST.last == null) {
            int temp = fixBST.first.val;
            fixBST.first.val = fixBST.middle.val;
            fixBST.middle.val = temp;
        } else {
            int temp = fixBST.first.val;
            fixBST.first.val = fixBST.last.val;
            fixBST.last.val = temp;
        }

        fixBST.inorder(fixBST.root);


    }
}

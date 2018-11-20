package prep.ds.tree;

/**
 * Created by sumit.jha on 09/10/18.
 */
public class BST {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public Node deleteBST(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteBST(root.left, key);
        } else if (key > root.val) {
            root.right = deleteBST(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                root.right = deleteBST(root.right, root.val);
            } else {
                if (root.left != null) {
                    root.val = root.left.val;
                    root.left = deleteBST(root.left, root.val);
                } else {
                    root.val = root.right.val;
                    root.right = deleteBST(root.right, root.val);
                }
            }
        }
        return root;
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new Node(100);
        bst.root.left = new Node(50);
        bst.root.right = new Node(200);
        bst.root.left.left = new Node(25);
        bst.root.left.right = new Node(70);
        bst.root.left.right.left = new Node(60);
        bst.root.left.right.right = new Node(80);

        bst.root.right.right = new Node(300);
        bst.root.right.right.right = new Node(400);

        bst.inorder(bst.root);
        System.out.println();

        bst.root = bst.deleteBST(bst.root, 200);
        bst.inorder(bst.root);


    }
}

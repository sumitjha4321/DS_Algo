package ds.bst;

/**
 * Created by sumit.jha on 28/06/18.
 */
public class SortedArrayToBST {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private static Node root;

    private static Node solve(int[] arr, Node root, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            root = new Node(arr[mid]);
            root.left = solve(arr, root.left, low, mid - 1);
            root.right = solve(arr, root.right, mid + 1, high);
        }
        return root;
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + "  ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {8, 10, 12, 15, 16, 20};
        SortedArrayToBST.root = solve(arr, SortedArrayToBST.root, 0, arr.length - 1);
        inorder(SortedArrayToBST.root);
        System.out.println();

    }
}

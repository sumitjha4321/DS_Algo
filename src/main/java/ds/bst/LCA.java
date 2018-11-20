package ds.bst;

/**
 * Created by sumit.jha on 27/06/18.
 */
public class LCA {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    private Node getLCA(Node root, int n1, int n2) {
        if (root == null) return root;
        if (n1 <= root.val && n2 <= root.val) {
            return getLCA(root.left, n1, n2);
        } else if (n1 >= root.val && n2 >= root.val) {
            return getLCA(root.right, n1, n2);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {

        LCA lca = new LCA();
        lca.root = new Node(20);
        lca.root.left = new Node(10);
        lca.root.right = new Node(30);
        lca.root.left.left = new Node(5);
        lca.root.left.right = new Node(18);
        lca.root.right.left = new Node(22);
        lca.root.right.right = new Node(40);

        System.out.println(lca.getLCA(lca.root, 5, 17).val);



    }
}

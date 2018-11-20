package prep.algo;

/**
 * Created by sumit.jha on 20/10/18.
 */
public class TBST {
    static class Node {
        char c;
        String val;
        boolean isEnd;
        Node left, mid, right;
    }

    Node root;


    Node insert(Node root, String key, String val, int pos) {
        if (root == null) {
            root = new Node();
            root.c = key.charAt(pos);
        }

        char c = key.charAt(pos);

        if (c < root.c) {
            root.left = insert(root.left, key, val, pos);
        } else if (c > root.c) {
            root.right = insert(root.right, key, val, pos);
        } else {
            if (pos == key.length() - 1) {
                root.val = val;
                root.isEnd = true;
            } else {
                root.mid = insert(root.mid, key, val, pos + 1);
            }
        }
        return root;
    }

    void printAllNodes(Node root, String key) {

        if (root == null) return;
        if (root.isEnd) {
            System.out.println(key + root.c + " --> " + root.val);
        }
        printAllNodes(root.left, key);
        printAllNodes(root.mid, key + root.c);
        printAllNodes(root.right, key);

    }


    public static void main(String[] args) {
        TBST tbst = new TBST();

        tbst.root = tbst.insert(tbst.root, "cat", "animal", 0);
        tbst.root = tbst.insert(tbst.root, "cow", "animal", 0);
        tbst.root = tbst.insert(tbst.root, "pigeon", "bird", 0);
        tbst.root = tbst.insert(tbst.root, "mat", "non living", 0);

        tbst.printAllNodes(tbst.root, "");


    }
}

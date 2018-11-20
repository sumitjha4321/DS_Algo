/**
 * Created by sumit.jha on 17/06/18.
 */
public class TST {

    Node root;

    public TST() {
    }

    static class Node {
        char c;
        boolean isEndOfWord;
        Node left, mid, right;

        public Node() {
        }
    }

    Node insert(Node root, String word, int idx) {
        if (root == null) {
            root = new Node();
            root.c = word.charAt(idx);
            //return root; This is difference from BST. You don't return here, because entire string might not have been processed
        }
        char c = word.charAt(idx);
        if (c < root.c) {
            root.left = insert(root.left, word, idx);
        } else if (c > root.c) {
            root.right = insert(root.right, word, idx);
        } else if (c == root.c && idx != word.length() - 1) {
            root.mid = insert(root.mid, word, idx + 1);
        } else {
            root.isEndOfWord = true;
        }
        return root;
    }

    void printAllWords(Node root, String buffer) {
        if (root == null) {
            return;
        }
        if (root.isEndOfWord) {
            System.out.println(buffer + root.c);
        }
        printAllWords(root.left, buffer);
        printAllWords(root.mid, buffer + root.c);
        printAllWords(root.right, buffer);
    }

    void printAllWordsPrefix(Node root, String prefix, int idx) {
        if (root == null) return;
        if (idx == prefix.length()) {
            printAllWords(root, prefix);
            return;
        }
        if (root.c == prefix.charAt(idx)) {
            printAllWordsPrefix(root.mid, prefix, idx + 1);
        } else if (prefix.charAt(idx) < root.c) {
            printAllWordsPrefix(root.left, prefix, idx);
        } else {
            printAllWordsPrefix(root.right, prefix, idx);
        }
    }

    public static void main(String[] args) {
        TST tst = new TST();
        tst.root = tst.insert(tst.root, "sea", 0);
        tst.root = tst.insert(tst.root, "see", 0);
        tst.root = tst.insert(tst.root, "low", 0);
        tst.root = tst.insert(tst.root, "lot", 0);
        tst.root = tst.insert(tst.root, "sum", 0);

        tst.printAllWordsPrefix(tst.root, "s", 0);

    }


}

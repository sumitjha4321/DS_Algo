package ds.others;

/**
 * Created by sumit.jha on 30/06/18.
 */
public class TST {
    static class Node {
        char c;
        boolean isEndOfWord;
        Node left, middle, right;

        public Node(char c) {
            this.c = c;
            this.isEndOfWord = false;
            this.left = this.middle = this.right = null;
        }
    }

    private Node root;

    public TST() {
        this.root = null;
    }

    private Node insert(Node root, String word, int idx) {
        if (root == null) {
            root = new Node(word.charAt(idx));
            if (idx == word.length() - 1) {
                root.isEndOfWord = true;
                return root;
            }
        }
        char c = word.charAt(idx);
        if ((c - 'a') == (root.c - 'a')) {
            root.middle = insert(root.middle, word, idx + 1);
        } else if ((c - 'a') < (root.c - 'a')) {
            root.left = insert(root.left, word, idx);
        } else {
            root.right = insert(root.right, word, idx);
        }
        return root;
    }

    private void printAllWords(Node root, String word) {
        if (root == null) {
            return;
        }

        if (root.isEndOfWord) {
            System.out.println(word + root.c);
        }

        printAllWords(root.left, word);
        printAllWords(root.middle, word + root.c);
        printAllWords(root.right, word);
    }

    private void printAllWordSuffix(Node root, String prefix, int idx) {
        if (root == null) {
            return;
        }
        if (idx == prefix.length() - 1) {
            printAllWords(root, prefix.substring(0, prefix.length() - 1));
            return;
        }
        if (root.c == prefix.charAt(idx)) {
            printAllWordSuffix(root.middle, prefix, idx + 1);
        } else if (root.c > prefix.charAt(idx)) {
            printAllWordSuffix(root.left, prefix, idx);
        } else {
            printAllWordSuffix(root.right, prefix, idx);
        }
    }

    public static void main(String[] args) {
        TST tst = new TST();
        tst.root = tst.insert(tst.root, "cat", 0);
        tst.root = tst.insert(tst.root, "mat", 0);
        tst.root = tst.insert(tst.root, "fat", 0);
        tst.root = tst.insert(tst.root, "hat", 0);
        tst.root = tst.insert(tst.root, "apple", 0);
        tst.root = tst.insert(tst.root, "man", 0);

        tst.printAllWordSuffix(tst.root, "hol", 0);

    }

}

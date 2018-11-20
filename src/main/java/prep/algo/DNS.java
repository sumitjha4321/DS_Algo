package prep.algo;

/**
 * Created by sumit.jha on 20/10/18.
 */
public class DNS {

    static class Node {
        boolean isEnd;
        String hostname;
        Node[] nodes;

        public Node() {
            this.isEnd = false;
            this.hostname = null;
            nodes = new Node[11];
        }
    }

    Node root;

    public DNS() {
        this.root = new Node();
    }

    void insert(Node root, String ip, String hostname) {
        for (int i = 0; i < ip.length(); i++) {
            int idx = ip.charAt(i) == '.' ? 10 : ip.charAt(i) - '0';
            if (root.nodes[idx] == null) {
                root.nodes[idx] = new Node();
            }
            root = root.nodes[idx];
        }
        root.isEnd = true;
        root.hostname = hostname;
    }

    void printAllHosts(Node root, String ip) {
        if (root == null) return;
        if (root.isEnd) {
            System.out.println(ip + " --> " + root.hostname);
        }
        for (int i = 0; i < 11; i++) {
            if (root.nodes[i] != null) {
                String c = i == 10 ? "." : String.valueOf(i);
                printAllHosts(root.nodes[i], ip + c);
            }
        }
    }

    public static void main(String[] args) {
        DNS dns = new DNS();

        dns.insert(dns.root, "7.4.2.3", "google.com");
        dns.insert(dns.root, "7.41.2.3", "facebook.com");

        dns.printAllHosts(dns.root, "");


    }


}

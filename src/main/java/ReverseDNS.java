/**
 * Created by sumit.jha on 14/06/18.
 */
public class ReverseDNS {

    static class Node {
        boolean isLeaf;
        String url;
        Node[] nodes;
        public Node() {
            this.isLeaf = false;
            nodes = new Node[11];
        }
    }

    Node root;

    public ReverseDNS() {
        this.root = new Node();
    }

    public void insert(String ip, String url) {
        Node temp = root;
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            int idx;
            if (c == '.') {
                idx = 10;
            } else {
                idx = Integer.parseInt(String.valueOf(c));
            }
            if (temp.nodes[idx]==null){
                temp.nodes[idx] = new Node();
            }
            temp = temp.nodes[idx];
        }
        temp.isLeaf = true;
        temp.url = url;
    }

    public String getUrlFromIp (String ip){
        Node temp = root;
        for (int i = 0; i < ip.length(); i++) {
            char c = ip.charAt(i);
            int idx;
            if (c == '.') {
                idx = 10;
            } else {
                idx = Integer.parseInt(String.valueOf(c));
            }
            if (temp.nodes[idx]==null){
                return null;
            }
            temp = temp.nodes[idx];
        }
        return temp.url;
    }

    private void printAllUrlUtils(Node node, String prefix){
        if (node == null){
            return;
        }
        if (node.isLeaf){
            System.out.println(prefix + " -> " + node.url);
        }
        for (int i = 0; i< 11; i++){
            if (i==10) {
                printAllUrlUtils(node.nodes[i], prefix + ".");
            } else {
                printAllUrlUtils(node.nodes[i], prefix + i);
            }
        }
    }
    public void printAllUrls(){
        printAllUrlUtils(root, "");
    }

    public static void main(String[] args) {

        ReverseDNS reverseDNS = new ReverseDNS();
        reverseDNS.insert("1.1.1.1", "www.google.com");
        reverseDNS.insert("1.2.1.2", "www.apple.com");
        reverseDNS.insert("2.2.2.2", "www.samsung.com");

        System.out.println("domain name is: "+ reverseDNS.getUrlFromIp("1.1.1.1"));
        reverseDNS.printAllUrls();
    }
}

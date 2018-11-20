package prep;

/**
 * Created by sumit.jha on 04/10/18.
 */
public class Delbst {

    static class Node {
        int ID;
        Node leftChild, rightChild;

        public Node(int ID) {
            this.ID = ID;
        }
    }

    public static Node deleteNode(Node root, int ID){

        if (root == null)  return root;
        if (ID < root.ID)
            root.leftChild = deleteNode(root.leftChild, ID);
        else if (ID > root.ID)
            root.rightChild = deleteNode(root.rightChild, ID);

        else
        {
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;

            root.ID = minValue(root.rightChild);
            root.rightChild = deleteNode(root.rightChild, root.ID);
        }

        return root;
    }


    static int minValue(Node root)
    {
        int minv = root.ID;
        while (root.leftChild != null)
        {
            minv = root.leftChild.ID;
            root = root.leftChild;
        }
        return minv;
    }

    static void inorder(Node root){
        if (root ==null)return;
        inorder(root.leftChild);
        System.out.print(root.ID + "  ");
        inorder(root.rightChild);
    }

    public static void main(String[] args) {
        Node root = new Node(60);
        root.leftChild = new Node(40);
        root.rightChild = new Node(109);
        root.leftChild.leftChild = new Node(20);
        root.leftChild.rightChild = new Node(49);

        inorder(root);
        System.out.println();
        deleteNode(root, 109);
        inorder(root);
        System.out.println();


    }
}

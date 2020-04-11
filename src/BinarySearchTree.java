import java.util.*;
import java.lang.String;

public class BinarySearchTree {
    class Node{
        int key;
        Node left, right;

        public Node(int node){
            key = node;
            left = right = null;
        }

    }

    Node root;

    BinarySearchTree(){
        root = null;
    }

    public Node insertRec(Node root, int node){
        if(root == null){
            root = new Node(node);
            return root;
        }

        if(node < root.key){
            root.left = insertRec(root.left, node);
        }else if(node > root.key){
            root.right = insertRec(root.right, node);
        }
        return root;
    }

    public void insert(int key){
        root = insertRec(root, key);
    }

    public void postorder(Node node){
        if(node != null){
            postorder(node.left);

            postorder(node.right);

            System.out.print(node.key + " ");
        }
    }

    public void printPostorder(){
        postorder(this.root);
    }

    public int sumInt(Node node){
        if(node == null){
            return 0;
        }
        return node.key + sumInt(node.left) + sumInt(node.right);
    }

    public int sum(){
        return sumInt(this.root);
    }

    public int searchKey(Node node, int findKey){
        if (node == null || node.key == findKey){
            return node.key;
        }
        if(findKey < node.key){
            return searchKey(node.left, findKey);
        }
        return searchKey(node.right, findKey);
    }

    public int search(int findKey){
        return  searchKey(this.root, findKey);
    }


}

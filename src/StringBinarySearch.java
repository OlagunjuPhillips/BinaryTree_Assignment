public class StringBinarySearch {
    class Node {
        String key;
        Node left, right;

        public Node(String node){
            key = node;
            left = right = null;
        }
    }

    Node root;

    public Node insertStr(Node root, String node){
        if(root == null){
            root = new Node(node);
            return root;
        }

        if(root.key.compareTo(node) < 0){
            root.left = insertStr(root.left, node);
        } else if(root.key.compareTo(node) > 0){
            root.right = insertStr(root.right, node);
        }
        return root;
    }

    public void insert(String key){
        root = insertStr(root, key);
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

    public boolean search(Node node, String findKey){
        if (node.key.equals(findKey)){
            return true;
        }
        if(node.key.compareTo(findKey) > 0){
            return search(node.left, findKey);
        }
        return search(node.right, findKey);
    }
}

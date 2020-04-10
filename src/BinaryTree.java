import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree<Type> {
    Node root;

    BinaryTree(Type key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }


    public void preorder(Node node){
        if(node != null){
            System.out.print(node.key +" ");

            preorder(node.left);

            preorder(node.right);
        }
    }

    public void printPreorder(){
        preorder(this.root);
    }


    public void inorder(Node node){
        if(node != null){
            inorder(node.left);

            System.out.print(node.key + " ");

            inorder(node.right);
        }
    }

    public void printInorder(){
        inorder(this.root);
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

    public boolean isFull(Node node){
        if(node == null){
            return true;
        }
        if(node.right == null && node.right == null){
            return true;
        }
        if(node.right != null && node.left != null){
            return isFull(node.right) && isFull(node.right);
        }
        return false;
    }

    public int countNumberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNumberOfNodes(node.left) + countNumberOfNodes(node.right);
    }

    public boolean isComplete(Node node, int index, int numberOfNodes){
        if(node == null){
            return true;
        }
        if(index >= numberOfNodes){
            return false;
        }

        return isComplete(node.left, 2 *(index + 1), numberOfNodes) &&
                isComplete(node.right, 2 *(index + 2), numberOfNodes);
    }

    public boolean isDegenerate(Node node){
        if(node.left == null){
            return true;
        }
        if(node.right == null){
            return true;
        }
        return false;
    }

    public int findDepth(Node node){
        int depth = 0;
        while(node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }

    public boolean checkIsPerfect(Node node, int depth, int level){
        if(root == null){
            return true;
        }

        if(node.left == null && node.right == null){
            return (depth == level+1);
        }

        if(node.left == null || node.right == null){
            return false;
        }

        return checkIsPerfect(node.left, depth, level+1) && checkIsPerfect(node.right, depth, level+1);
    }

    public boolean isPerfect(Node node){
        int height = findDepth(node);
        return checkIsPerfect(node, height, 0);
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(Node node){
        int leftHeight = 0;
        int rightHeight = 0;

        if(node == null){
            return true;
        }

        leftHeight = height(node.left);
        rightHeight = height(node.right);

        if(Math.abs(leftHeight - rightHeight) == 1  && isBalanced(node.left) && isBalanced(node.right)){
            return true;
        }
        return false;
    }

    public void insertNode(Node node, Type key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<Node> checked = new ArrayList<>();


        while(!queue.isEmpty()){
            node = queue.peek();
            queue.remove();

            if(!checked.contains(node)) {
                checked.add(node);
                if (node.left == null) {
                    node.left = new Node(key);
                    break;
                } else {
                    queue.add(node.left);
                }

                if(node.right == null){
                    node.right = new Node(key);
                    break;
                }else{
                    queue.add(node.right);
                }
            }


        }
    }

    public BinaryTree<String> createRandomTree(String [] names){
        Random rand = new Random();
        String[] coin = {"head", "tail"};
        BinaryTree<String> randomTree = new BinaryTree<>();
        randomTree.root = new Node(names[0]);

        for(int i = 1; i < names.length; i++){
            String decision = coin[rand.nextInt(coin.length)];

            if(decision.equals("head")){
                if(randomTree.root.left != null) {
                    insertNode(randomTree.root.left, (Type) names[i]);
                }else{
                    randomTree.root.left = new Node(names[i]);
                }
            }else{
                if(randomTree.root.right != null) {
                    insertNode(randomTree.root.right, (Type) names[i]);
                }else{
                    randomTree.root.right = new Node(names[i]);
                }
            }
        }
        return randomTree;
    }
}

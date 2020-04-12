import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree<Type> {
    Node root;


    BinaryTree (Type key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }

    public void printPreorder(){
        if(root != null){
            System.out.print(root.key +" ");

            BinaryTree<Type> leftSubtree = new BinaryTree<>();
            leftSubtree.root = root.left;

            leftSubtree.printPreorder();

            BinaryTree<Type> rightSubtree = new BinaryTree<>();
            rightSubtree.root = root.right;
            rightSubtree.printPreorder();
        }
    }


    public void printInorder(){
        if(root != null){
            BinaryTree<Type> leftSubtree = new BinaryTree<>();
            leftSubtree.root = root.left;
            leftSubtree.printInorder();

            System.out.print(root.key + " ");

            BinaryTree<Type> rightSubtree = new BinaryTree<>();
            rightSubtree.root = root.right;
            rightSubtree.printInorder();
        }
    }
    public void printPostorder(){
        if(root != null){
            BinaryTree<Type> leftSubtree = new BinaryTree<>();
            leftSubtree.root = root.left;
            leftSubtree.printPostorder();

            BinaryTree<Type> rightSubtree = new BinaryTree<>();
            rightSubtree.root = root.right;
            rightSubtree.printPostorder();

            System.out.print(root.key + " ");
        }
    }


    public boolean isFull(){



        if(root == null){
            return true;
        }
        if(root.right == null && root.right == null){
            return true;
        }
        if(root.right != null && root.left != null){
            BinaryTree<Type> leftSubtree = new BinaryTree<>();
            leftSubtree.root = root.left;
            BinaryTree<Type> rightSubtree = new BinaryTree<>();
            rightSubtree.root = root.right;
            return leftSubtree.isFull() && rightSubtree.isFull();
        }
        return false;
    }

    public int countNumberOfNodes(){

        if(root == null){
            return 0;
        }
        BinaryTree<Type> leftSubtree = new BinaryTree<>();
        leftSubtree.root = root.left;
        BinaryTree<Type> rightSubtree = new BinaryTree<>();
        rightSubtree.root = root.right;
        return 1 + leftSubtree.countNumberOfNodes() + rightSubtree.countNumberOfNodes();
    }

    public boolean isComplete(int index, int numberOfNodes){
        if(root == null){
            return true;
        }
        if(index >= numberOfNodes){
            return false;
        }
        BinaryTree<Type> leftSubtree = new BinaryTree<>();
        leftSubtree.root = root.left;
        BinaryTree<Type> rightSubtree = new BinaryTree<>();
        rightSubtree.root = root.right;
        return leftSubtree.isComplete(2 *(index + 1), numberOfNodes) &&
                rightSubtree.isComplete(2 *(index + 2), numberOfNodes);
    }

    public boolean isDegenerate(){
        if(root.left == null){
            return true;
        }
        if(root.right == null){
            return true;
        }
        return false;
    }

    public int findDepth(){
        int depth = 0;
        while(root != null){
            depth++;
            root = root.left;
        }
        return depth;
    }

    public boolean checkIsPerfect(int depth, int level){
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return (depth == level+1);
        }

        if(root.left == null || root.right == null){
            return false;
        }

        BinaryTree<Type> leftSubtree = new BinaryTree<>();
        leftSubtree.root = root.left;
        BinaryTree<Type> rightSubtree = new BinaryTree<>();
        rightSubtree.root = root.right;
        return leftSubtree.checkIsPerfect(depth, level+1) && rightSubtree.checkIsPerfect(depth, level+1);
    }

    public boolean isPerfect(){
        int height = findDepth();
        return checkIsPerfect(height, 0);
    }

    public int height(){
        if(root == null){
            return 0;
        }

        BinaryTree<Type> leftSubtree = new BinaryTree<>();
        leftSubtree.root = root.left;
        BinaryTree<Type> rightSubtree = new BinaryTree<>();
        rightSubtree.root = root.right;
        return 1 + Math.max(leftSubtree.height(), rightSubtree.height());
    }

    public boolean isBalanced(){
        int leftHeight = 0;
        int rightHeight = 0;

        if(root == null){
            return true;
        }

        BinaryTree<Type> leftSubtree = new BinaryTree<>();
        leftSubtree.root = root.left;
        BinaryTree<Type> rightSubtree = new BinaryTree<>();
        rightSubtree.root = root.right;
        leftHeight = leftSubtree.height();
        rightHeight = rightSubtree.height();

        if(Math.abs(leftHeight - rightHeight) == 1  && leftSubtree.isBalanced() && rightSubtree.isBalanced()){
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

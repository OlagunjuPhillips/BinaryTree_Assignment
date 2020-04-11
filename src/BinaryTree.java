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

    // TODO FIX THIS.  Phillips, I know this is how this code was written but it's not correct.  That is, it works but it
    //  should not have a parameter.  Why?  Because the object that calls this method, already knows its root Node.
    //  The call should be
    //      someBinaryTree.preorder();
    //  Notice that it's the object (someBinaryTree) that should be output, not some other Node parameter.
    //  If the left subtree of someBinaryTree wants to call preorder().  This is done like
    //      someBinaryTree.left.preorder();
    //  or maybe
    //      someBinaryTree.getLeft().preorder();
    //
    public void preorder(Node node){
        if(node != null){
            System.out.print(node.key +" ");

            preorder(node.left);

            preorder(node.right);
        }
    }

    // TODO FIX THIS.  Phillips, this is called a "helper method".  It is only needed to setup preorder or as a convenience
    //  to make it easier to use preorder().  Just by making the change to preorder() as I mention above, this
    //  convenience method is no longer needed.
    public void printPreorder(){
        preorder(this.root);
    }

    // TODO Phillips, see my comments at preorder().
    public void inorder(Node node){
        if(node != null){
            inorder(node.left);

            System.out.print(node.key + " ");

            inorder(node.right);
        }
    }

    // TODO Phillips, see my comments at printPreorder().
    public void printInorder(){
        inorder(this.root);
    }

    // TODO Phillips, see my comments at preorder().
    public void postorder(Node node){
        if(node != null){
            postorder(node.left);

            postorder(node.right);

            System.out.print(node.key + " ");
        }
    }

    // TODO Phillips, see my comments at printPreorder().
    public void printPostorder(){
        postorder(this.root);
    }

    // TODO Phillips, see my comments at preorder();
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

    // TODO Phillips, see my comments at preorder();
    public int countNumberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNumberOfNodes(node.left) + countNumberOfNodes(node.right);
    }

    // TODO Phillips, see my comments at preorder();
    //  This method needs the index and the numberOfNodes, but not the Node parameter.
    //  This is the type of function that can use a helper/convenience method so the user can call
    //      someBinaryTree.isComplete()
    //  and the only statement in BinaryTree.isComplete() is
    //      return this.isComplete( 0, this.size() );
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

    // TODO Phillips, see my comments at preorder().
    //   This code determines if a single node has an empty left or an empty right.
    //   This method should be called isNotLeaf().
    //   To determine degenerate, the binary tree must look like a line of nodes so if left child, then all left children,
    //   or if right child, then all right children.
    public boolean isDegenerate(Node node){
        if(node.left == null){
            return true;
        }
        if(node.right == null){
            return true;
        }
        return false;
    }

    // TODO Phillips, see my comments at preorder().
    //  So the depth is only about going left?  What if the tree is a degenerate tree skewed to the right?
    public int findDepth(Node node){
        int depth = 0;
        while(node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }

    // TODO Phillips, see my comments at preorder().
    //  A perfect tree has same depth in right and left subtrees and every non-leaf has left and right subtrees.
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

    // TODO Phillips, see my comments at printPreorder().
    public boolean isPerfect(Node node){
        int height = findDepth(node);
        return checkIsPerfect(node, height, 0);
    }

    // TODO Phillips, see my comments at preorder().
    public int height(Node node){
        if(node == null){
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // TODO Phillips, see my comments at preorder().
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

    // TODO Phillips, see my comments at preorder().
    public void insertNode(Node node, Type key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<Node> checked = new ArrayList<>();

        // TODO Phillips, it's useful to write a comment when a block of code (like this while-loop) is long
        //  and complicated.  Maybe something like
        //
        while(!queue.isEmpty()){
            node = queue.peek();
            queue.remove();

            if(!checked.contains(node)) {
                checked.add(node);
                if (node.left == null) {
                    node.left = new Node(key);
                    break;  // Oh no!
                } else {
                    queue.add(node.left);
                }

                if(node.right == null){
                    node.right = new Node(key);
                    break;  // Oh no!
                }else{
                    queue.add(node.right);
                }
            }


        }
    }

    // TODO FIX THIS.
    //  (1) create a node by randomly selecting a name from the names array.
    //  (2) randomly select either HEAD or TAIL.
    //  (3) if HEAD then attach if left==null otherwise move left, flip coin again, and repeat until find an empty slot.
    //  (4) if TAIL then attach if right==null otherwise move right, flip coin again, and repeat until find an empty slot.
    public BinaryTree<String> createRandomTree(String [] names){
        Random rand = new Random();
        String[] coin = {"head", "tail"};  // TODO This should be an "enumerated type".
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

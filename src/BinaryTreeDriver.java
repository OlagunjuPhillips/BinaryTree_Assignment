import java.util.jar.JarOutputStream;

public class BinaryTreeDriver {
    static final String[] NAMES = {"James", "Paul", "Jones", "Jake", "Will", "Pete", "Smith", "Jack", "Trish"};
    public static void main(String[] args){
        System.out.println("=== My first Binary Tree Program ===");

        System.out.println("=== TREE1 DATA ===");
        System.out.println();
        System.out.println("Creating tree1... Done.");
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        System.out.println("Printing tree1 using preorder traversal...");
        tree1.printPreorder();

        System.out.println();
        System.out.println("Done.");
        System.out.println();

        System.out.println("Checking if tree1 is full...");
        if(tree1.isFull()){
            System.out.println("tree1 is full");
        }else{
            System.out.println("tree1 is not full");
        }
        System.out.println();

        System.out.println("Checking if tree1 is complete...");
        if(tree1.isComplete(0, tree1.countNumberOfNodes())){
            System.out.println("tree1 is complete.");
        }else{
            System.out.println("tree1 is not complete.");
        }
        System.out.println();

        System.out.println("Checking if tree1 is degenerate...");
        if(tree1.isDegenerate()){
            System.out.println("tree1 is degenerate.");
        }else{
            System.out.println("tree1 is not degenerate.");
        }
        System.out.println();

        System.out.println("Checking if tree1 is perfect...");
        if(tree1.isPerfect()){
            System.out.println("tree1 is perfect.");
        }else{
            System.out.println("tree1 is not perfect.");
        }
        System.out.println();

        System.out.println("Checking if tree1 is balanced...");
        if(tree1.isBalanced()){
            System.out.println("tree1 is balanced.");
        }else{
            System.out.println("tree1 is not balanced.");
        }
        System.out.println();

        System.out.println("=== TREE2 DATA ===");
        System.out.println();
        System.out.println("Creating tree2... Done.");
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.root = new Node (1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.right.left = new Node(6);
        tree2.root.right.right = new Node(7);
        tree2.root.left.left.left = new Node(8);
        tree2.root.left.left.right = new Node(9);
        tree2.root.left.right.left = new Node(10);
        System.out.println("Printing tree2 using inorder traversal...");
        tree2.printInorder();
        System.out.println();
        System.out.println("Done.");
        System.out.println();


        System.out.println("Checking if tree2 is full...");
        if(tree2.isFull()){
            System.out.println("tree2 is full");
        }else{
            System.out.println("tree2 is not full");
        }
        System.out.println();

        System.out.println("Checking if tree2 is complete...");
        if(tree2.isComplete(0, tree2.countNumberOfNodes())){
            System.out.println("tree2 is complete.");
        }else{
            System.out.println("tree2 is not complete.");
        }
        System.out.println();

        System.out.println("Checking if tree2 is degenerate...");
        if(tree2.isDegenerate()){
            System.out.println("tree2 is degenerate.");
        }else{
            System.out.println("tree2 is not degenerate.");
        }
        System.out.println();

        System.out.println("Checking if tree2 is perfect...");
        if(tree2.isPerfect()){
            System.out.println("tree2 is perfect.");
        }else{
            System.out.println("tree2 is not perfect.");
        }
        System.out.println();

        System.out.println("Checking if tree2 is balanced...");
        if(tree2.isBalanced()){
            System.out.println("tree2 is balanced.");
        }else{
            System.out.println("tree2 is not balanced.");
        }
        System.out.println();

        System.out.println("=== TREE3 DATA ===");
        System.out.println();
        System.out.println("Creating tree3... Done.");
        BinaryTree<String> tree3 = new BinaryTree<>();

        tree3.root = new Node("apple");
        tree3.root.left = new Node("banana");
        tree3.root.right = new Node("cherry");
        tree3.root.left.left = new Node("dates");
        tree3.root.left.right = new Node("elderberry");
        System.out.println("Printing tree3 using postorder traversal...");
        tree3.printPostorder();
        System.out.println();
        System.out.println("Done.");
        System.out.println();

        System.out.println("Checking if tree3 is full...");
        if(tree3.isFull()){
            System.out.println("tree3 is full");
        }else{
            System.out.println("tree3 is not full");
        }
        System.out.println();

        System.out.println("Checking if tree3 is complete...");
        if(tree3.isComplete(0, tree3.countNumberOfNodes())){
            System.out.println("tree3 is complete.");
        }else{
            System.out.println("tree3 is not complete.");
        }
        System.out.println();

        System.out.println("Checking if tree3 is degenerate...");
        if(tree3.isDegenerate()){
            System.out.println("tree3 is degenerate.");
        }else{
            System.out.println("tree3 is not degenerate.");
        }
        System.out.println();

        System.out.println("Checking if tree3 is perfect...");
        if(tree3.isPerfect()){
            System.out.println("tree3 is perfect.");
        }else{
            System.out.println("tree3 is not perfect.");
        }
        System.out.println();

        System.out.println("Checking if tree3 is balanced...");
        if(tree3.isBalanced()){
            System.out.println("tree3 is balanced.");
        }else{
            System.out.println("tree3 is not balanced.");
        }


        System.out.println("Creating random tree...");
        BinaryTree<String> random = new BinaryTree<>();
        random = random.createRandomTree(NAMES);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Printing tree4 using postorder traversal...");
        random.printPostorder();
    }
}

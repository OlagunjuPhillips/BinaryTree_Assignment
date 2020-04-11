import java.util.jar.JarOutputStream;

public class BinaryTreeDriver {
    static final String[] NAMES = {"James", "Paul", "Jones", "Jake", "Will", "Pete", "Smith", "Jack", "Trish"};
    public static void main(String[] args){
        System.out.println("=== My first Binary Tree Program ===");

        System.out.println("=== TREE1 DATA ===\n");

        System.out.println("Creating tree1... ");
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        System.out.println("Done.");

        System.out.println("\nPrinting tree1 using preorder traversal...");
        tree1.printPreorder();
        System.out.println();
        System.out.println("Done.");

        System.out.println("\nChecking if tree1 is full... ");
        if(tree1.isFull(tree1.root)){
            System.out.println("It is full");
        }else{
            System.out.println("It is not full");
        }

        System.out.println("\nChecking if tree1 is complete... ");
        if(tree1.isComplete(tree1.root, 0, tree1.countNumberOfNodes(tree1.root))){
            System.out.println("It is complete.");
        }else{
            System.out.println("It is not complete.");
        }

        System.out.println("\nChecking if tree1 is degenerate... ");
        if(tree1.isDegenerate(tree1.root)){
            System.out.println("It is degenerate.");
        }else{
            System.out.println("It is not degenerate.");
        }

        System.out.println("\nChecking if tree1 is perfect... ");
        if(tree1.isPerfect(tree1.root)){
            System.out.println("It is perfect.");
        }else{
            System.out.println("It is not perfect.");
        }

        System.out.println("\nChecking if tree1 is balanced... ");
        if(tree1.isBalanced(tree1.root)){
            System.out.println("It is balanced.");
        }else{
            System.out.println("It is not balanced.");
        }

        System.out.println("\n=== TREE2 DATA ===");
        System.out.println();
        System.out.println("Creating tree2... ");
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
        System.out.println("Done.");

        System.out.println("\nPrinting tree2 using inorder traversal... ");
        tree2.printInorder();
        System.out.println();
        System.out.println("Done.");

        System.out.println("\nChecking if tree2 is full... ");
        if(tree2.isFull(tree2.root)){
            System.out.println("It is full");
        }else{
            System.out.println("It is not full");
        }

        System.out.println("\nChecking if tree2 is complete... ");
        if(tree2.isComplete(tree2.root, 0, tree2.countNumberOfNodes(tree2.root))){
            System.out.println("It is complete.");
        }else{
            System.out.println("It is not complete.");
        }

        System.out.println("\nChecking if tree2 is degenerate... ");
        if(tree2.isDegenerate(tree2.root)){
            System.out.println("It is degenerate.");
        }else{
            System.out.println("It is not degenerate.");
        }

        System.out.println("\nChecking if tree2 is perfect... ");
        if(tree2.isPerfect(tree2.root)){
            System.out.println("It is perfect.");
        }else{
            System.out.println("It is not perfect.");
        }

        System.out.println("\nChecking if tree2 is balanced... ");
        if(tree2.isBalanced(tree2.root)){
            System.out.println("It is balanced.");
        }else{
            System.out.println("It is not balanced.");
        }

        System.out.println("\n=== TREE3 DATA ===");

        System.out.println("\nCreating tree3... ");
        BinaryTree<String> tree3 = new BinaryTree<>();

        tree3.root = new Node("apple");
        tree3.root.left = new Node("banana");
        tree3.root.right = new Node("cherry");
        tree3.root.left.left = new Node("dates");
        tree3.root.left.right = new Node("elderberry");
        System.out.println("Done.");

        System.out.println("\nPrinting tree3 using postorder traversal...");
        tree3.printPostorder();
        System.out.println("\nDone.");

        System.out.println("\nChecking if tree3 is full... ");
        if(tree3.isFull(tree3.root)){
            System.out.println("It is full");
        }else{
            System.out.println("It is not full");
        }

        System.out.println("\nChecking if tree3 is complete... ");
        if(tree3.isComplete(tree3.root, 0, tree3.countNumberOfNodes(tree3.root))){
            System.out.println("It is complete.");
        }else{
            System.out.println("It is not complete.");
        }

        System.out.println("\nChecking if tree3 is degenerate... ");
        if(tree3.isDegenerate(tree3.root)){
            System.out.println("It is degenerate.");
        }else{
            System.out.println("It is not degenerate.");
        }

        System.out.println("\nChecking if tree3 is perfect... ");
        if(tree3.isPerfect(tree3.root)){
            System.out.println("It is perfect.");
        }else{
            System.out.println("It is not perfect.");
        }

        System.out.println("\nChecking if tree3 is balanced... ");
        if(tree3.isBalanced(tree3.root)){
            System.out.println("It is balanced.");
        }else{
            System.out.println("It is not balanced.");
        }


        System.out.println("\nCreating random tree... ");
        BinaryTree<String> tree4 = new BinaryTree<>();
        tree4 = tree4.createRandomTree(NAMES);
        System.out.println("Done.");

        System.out.println("\nPrinting tree4 using postorder traversal... ");
        tree4.printPostorder();
    }
}

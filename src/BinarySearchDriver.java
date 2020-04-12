public class BinarySearchDriver {
    public static void main(String[] args) {
        System.out.println("=== Binary Search Program ===");
        System.out.println("Creating tree4...");
        BinarySearchTree tree4 = new BinarySearchTree();
        int[] tree = {3, 1, 2, 4};
        for(int num : tree){
            tree4.insert(num);
        }
        System.out.println("Done.");

        System.out.println("\nChecking that search method exists...");
        System.out.println(tree4.search(4));
        System.out.println("Done.");


        System.out.println("Creating tree5...");
        BinarySearchTree tree5 = new BinarySearchTree();
        int[] trees5 = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};

        for(int num : trees5){
            tree5.insert(num);
        }
        System.out.println("Done");
        System.out.println("\nChecking that sum method exists...");
        tree5.printInorder();
        System.out.println("\n"+tree5.sum());
        System.out.println("Done.");


        System.out.println("\nChecking that nth greatest value method exists...\nFind the 4th greatest value of tree5.");
        tree5.printInorder();
        System.out.println("\n"+tree5.nthLargest(4));


        System.out.println("\nCreating tree6...");
        String[] tree6List = {"apple", "banana", "cherry", "dates", "elderberry", "fig"};
        StringBinarySearch tree6 = new StringBinarySearch();
        for(String word : tree6List){
            tree6.insert(word);
        }
        System.out.println("Done.");
        tree6.printPostorder();


    }



}

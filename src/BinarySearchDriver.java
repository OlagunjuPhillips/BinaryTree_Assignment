public class BinarySearchDriver {
    public static void main(String[] args) {
        BinarySearchTree trees = new BinarySearchTree();

        int[] tree = {3, 1, 2, 4};
        for(int num : tree){
            trees.insert(num);
        }
        System.out.println(trees.sum());
        System.out.println(trees.search(3));
        System.exit(5);

        BinarySearchTree trees2 = new BinarySearchTree();
        int[] tree2 = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};

        for(int num : tree2){
            trees2.insert(num);
        }
        trees2.printPostorder();
        System.out.println();

        String[] tree6List = {"apple", "banana", "cherry", "dates", "elderberry", "fig"};
        StringBinarySearch tree6 = new StringBinarySearch();
        for(String word : tree6List){
            tree6.insert(word);
        }

        tree6.printPostorder();


    }



}

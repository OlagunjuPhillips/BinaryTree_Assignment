public class BinaryHeapDriver {
    public static void main(String[] args) {
        System.out.println("Binary Heap Program.");

        System.out.println("Creating tree7...");
        int[] heap2l = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};
        MaxHeap tree7 = new MaxHeap(11);
        for(int node : heap2l){
            tree7.insert(node);
        }
        System.out.println("Done.");

        System.out.println("Checking that nth greatest value method exists...");
        tree7.print();
        System.out.println("5th greatest value of tree7 is " + tree7.kthLargest(5));


        System.out.println("Checking that search method exists...");
        System.out.println("Searching tree for key 6...");
        System.out.println(tree7.search(6, 1));
        System.out.println("Searching tree for key 11...");
        System.out.println(tree7.search(11, 1));

        System.out.println("Checking that sort method exists...");
        int[] unnsorted = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};
        unnsorted = sort(unnsorted);
        for (int value : unnsorted) {
            System.out.println(value);
        }
    }

    static int[] sort(int[] nums){
        int[] sorted = new int[nums.length];
        MaxHeap sort = new MaxHeap(nums.length);
        for(int num : nums){
            sort.insert(num);
        }

        for(int i = 0; i < sort.size(); i++){
            sorted[i] = sort.extractMax();
            sort.print();
            System.out.println();

        }
        return sorted;
    }
}

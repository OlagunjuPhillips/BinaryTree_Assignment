public class BinaryHeapDriver {
    public static void main(String[] args) {
        int[] heapl = {4, 1, 2, 3};
        MinHeap heap = new MinHeap(5);

        for(int node : heapl){
            heap.insert(node);
        }

        heap.print();
        System.out.println();

        int[] heap2l = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};
        MaxHeap heap2 = new MaxHeap(11);

        for(int node : heap2l){
            heap2.insert(node);
        }
        heap2.print();


        System.out.println(heap2.search(6, 1));

        int[] unnsorted = {3, 1, 2, 4, 10, 8, 9, 7, 6, 5};

        unnsorted = sort(unnsorted);
        for (int value : unnsorted) {
            System.out.println(value);
        }
    }

    static int[] sort(int[] nums){
        int[] sorted = new int[nums.length];
        MaxHeap sort = new MaxHeap(nums.length + 1);
        for(int num : nums){
            sort.insert(num);
            sort.print();
            System.out.println();
        }

        for(int i = 0; i < sort.size(); i++){
            sorted[i] = sort.extractMax();
        }
        return sorted;
    }
}

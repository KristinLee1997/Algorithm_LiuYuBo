package structure.heap.heap_sort_summary;


/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 14:30
 * @desc
 **/
public class HeapSort1 {
    private HeapSort1() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxheap = new MaxHeap<Comparable>(n);
        for (int i = 0; i < n; i++) {
            maxheap.insert(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i]=maxheap.extractMax();
        }
    }

    public static void main(String[] args) {
        Integer[] arr={1,5,9,7,3,4,8,6,2,11,15,19,17,18,16,13,14,10,20};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

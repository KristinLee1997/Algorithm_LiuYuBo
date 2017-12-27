package structure.heap.heapify;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 14:45
 * @desc
 **/
public class HeapSort2 {
    private HeapSort2() {
    }
    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxheap = new MaxHeap<Comparable>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxheap.extractMax();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 15, 19, 17, 18, 16, 13, 14, 10, 20};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

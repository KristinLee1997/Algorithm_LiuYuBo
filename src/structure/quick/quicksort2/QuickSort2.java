package structure.quick.quicksort2;


/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 9:45
 * @desc:快速排序--解决了有序数组问题,但是对于数组中存在大量相同元素问题仍未解决
 **/
public class QuickSort2 {
    private QuickSort2() {
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void sort(Comparable[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        if (r - l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }
        int pos = partition(arr, l, r);
        sort(arr, l, pos - 1);
        sort(arr, pos + 1, r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int swaptimes = 10;
        int n = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(n,0,n);
        SortTestHelper.testSort("structure.quick.quicksort2.QuickSort2",arr);
//        sort(arr);
//        SortTestHelper.printArray(arr);
        return;
    }
}

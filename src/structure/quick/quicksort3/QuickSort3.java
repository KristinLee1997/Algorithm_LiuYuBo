package structure.quick.quicksort3;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 10:16
 * @desc 快速排序--解决了有序数组问题和数组中存在大量相同元素问题
 **/
public class QuickSort3 {
    private QuickSort3() {
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
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
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2};
        sort(arr);
        SortTestHelper.printArray(arr);
    }

}

package structure.quick.quicksort4;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 16:03
 * @desc:两路快排,partation时不用交换
 **/
public class QuickSort4 {
    private QuickSort4() {
    }

    private static <T extends Comparable<? super T>> int partation(T[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        T v = arr[l];
        int i = l + 1, j = r;
        while (i < j) {
            while (i < j && v.compareTo(arr[j]) < 0) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && v.compareTo(arr[i]) > 0) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = v;
        return j;
    }

    private static <T extends Comparable<? super T>> void sort(T[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int pos = partation(arr, l, r);
        sort(arr, l, pos - 1);
        sort(arr, pos + 1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        if (i != j) {
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

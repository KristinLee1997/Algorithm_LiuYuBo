package structure.sort_summary;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 14:45
 * @desc 快速排序--两路排序而且不用交换值
 **/
public class QuickSort_TwoWays {
    private QuickSort_TwoWays() {
    }


    private static <T extends Comparable<? super T>> int partation(T[] arr, int left, int right) {
        swap(arr, left, (int) (Math.random() * (right - left) + left));
        T base = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && base.compareTo(arr[j]) < 0) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && base.compareTo(arr[i]) > 0) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = base;
        return j;
    }

    private static <T extends Comparable<? super T>> void sort(T[] arr, int left, int right, int k) {
        if (right - left <= k) {
            insertionRangeSort(arr, left, right);
            return;
        }
        int pos = partation(arr, left, right);
        sort(arr, left, pos - 1, k);
        sort(arr, pos + 1, right, k);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1, 16);
    }

    //指定范围执行插入排序
    public static <T extends Comparable<? super T>> void insertionRangeSort(T[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            T temp = arr[i];
            int j = i - 1;
            for (; j >= l && temp.compareTo(arr[j]) < 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 17, 10, 19, 13, 16, 18, 12, 14, 20};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

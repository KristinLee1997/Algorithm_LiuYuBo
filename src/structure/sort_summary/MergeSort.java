package structure.sort_summary;

import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 13:32
 * @desc 归并排序
 **/
public class MergeSort {
    private MergeSort() {
    }

    //合并
    private static <T extends Comparable<? super T>> void merge(T[] arr, int left, int mid, int right) {
        T[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
        for (int k = 0; k < arr.length; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    //归一
    private static <T extends Comparable<? super T>> void sort(T[] arr, int left, int right, int k) {
        if (right - left <= k) {
            insertionRangeSort(arr, left, right);
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid - 1, k);
        sort(arr, mid + 1, right, k);
        merge(arr, left, mid, right);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1, 15);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 17, 10, 19, 13, 16, 18, 12, 14, 20};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

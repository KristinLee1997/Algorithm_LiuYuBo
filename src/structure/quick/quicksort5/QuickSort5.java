package structure.quick.quicksort5;

import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 16:25
 * @desc: 三路快排
 **/
public class QuickSort5 {
    private QuickSort5() {
    }

    private static <T extends Comparable<? super T>> int[] partation(T[] arr, int left, int right) {
        swap(arr, left, (int) (Math.random() * (right - left + 1) + left));
        T base = arr[left];
        int i = left;
        int j = right;
        int cur = i;
        while (cur <= j) {
            if (base.compareTo(arr[cur]) == 0) {
                cur++;
            } else if (base.compareTo(arr[cur]) > 0) {
                swap(arr, cur++, i++);
            } else {
                swap(arr, cur, j--);
            }
        }
        return new int[]{i - 1, j + 1};
    }

    private static <T extends Comparable<? super T>> void sort(T[] arr, int left, int right, int k) {
        if (right - left <= k) {
            InsertionSort.sort(arr, left, right);
            return;
        }
        int ret[] = partation(arr, left, right);
        sort(arr, left, ret[0], k);
        sort(arr, ret[1], right, k);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr, int k) {
        sort(arr, 0, arr.length - 1, k);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20, 0, 20);
        sort(arr,15);
        SortTestHelper.printArray(arr);
    }
}

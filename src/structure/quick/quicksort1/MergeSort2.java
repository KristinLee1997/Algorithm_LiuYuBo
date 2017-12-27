package structure.quick.quicksort1;

import structure.merge.mergesort2.InsertionSort;
import structure.merge.mergesort2.SortTestHelper;

import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/11/30 17:33
 * @desc
 **/
public class MergeSort2 {
    private MergeSort2() {
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        //优化二:对于几乎有序的数组,使用直接插入排序时间复杂度更低
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        //优化一:对于arr[mid] <= arr[mid+1]的情况,不进行merge
        //对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 4, 8, 6, 2};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

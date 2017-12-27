package structure.merge.mergesort2;

import java.util.Arrays;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/30 14:24
 * Goal:
 **/
public class MergeSort1 {
    private MergeSort1() {
    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行合并
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

    //通过递归对arr[l...r]的范围进行归一
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
//        int n = 1000000;
//        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 1000000);
//        SortTestHelper.testSort("structure.merge.mergesort1.MergeSort1", arr);
        Integer[] arr = {1, 5, 9, 7, 3, 6, 4, 2, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

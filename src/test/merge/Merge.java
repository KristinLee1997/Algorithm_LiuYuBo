package test.merge;

import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 12:12
 * @desc
 **/
public class Merge {
    //将数组中元素按序合并
    private static <T extends Comparable<? super T>> void merge(T[] arr, int low, int mid, int high) {
        T[] ret = Arrays.copyOfRange(arr, low, high + 1);
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {   //说明i全排完了
                arr[k] = ret[j - low];
                j++;
            } else if (j > high) {  //说明j全排完了
                arr[k] = ret[i - low];
                i++;
            } else if (ret[i - low].compareTo(ret[j - low]) < 0) { //判断i,j对应元素哪个小就把那个赋给arr[k]
                arr[k] = ret[i - low];
                i++;
            } else {        //判断i,j对应元素哪个小就把那个赋给arr[k]
                arr[k] = ret[j - low];
                j++;
            }
        }
    }

    //将数组中元素进行归一
    private static <T extends Comparable<? super T>> void sort(T[] arr, int low, int high) {
//        if (low >= high) {
//            return;
//        }
        //优化(归并+直接插入):对于数组基本有序的情况,使用直接插入排序
        if (high - low <= 15) {
            insertionSort(arr, low, high);
            return;
        }
        int mid = (low & high) + ((low ^ high) >> 1);
        sort(arr, 0, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void insertionSort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(temp) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    //打印数组
    public static <T extends Comparable<? super T>> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 4, 8, 6, 2};
        sort(arr);
        printArray(arr);
    }
}

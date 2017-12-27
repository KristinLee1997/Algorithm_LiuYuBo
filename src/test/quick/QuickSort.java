package test.quick;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 15:26
 * @desc
 **/

/**
 * 简单快速排序--对于基本有序的数组和重复元素较多的数组时间复杂度较高,存在不足需要改进
 */
public class QuickSort {
    private QuickSort() {
    }

    private static <T extends Comparable<? super T>> int[] partition(T[] arr, int low, int high) {
        swap(arr, low, (int) (Math.random() * (high - low + 1) + low));
        T temp = arr[low];
        int i = low;
        int j = high;
        int cur = i;
        while (cur <= j) {
            if (temp.compareTo(arr[cur]) == 0) {
                cur++;
            } else if (temp.compareTo(arr[cur]) > 0) {
                swap(arr, cur++, i++);
            } else {
                swap(arr, cur, j--);
            }
        }
        return new int[]{i - 1, j + 1};
    }

    private static <T extends Comparable<? super T>> void sort(T[] arr, int low, int high) {
        if (high - low <= 15) {
            insertionSort(arr, low, high);
            return;
        }

        int[] ret = partition(arr, low, high);
        sort(arr, low, ret[0]);
        sort(arr, ret[1], high);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    private static void insertionSort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(temp) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    //交换数组中的两个元素
    private static <T extends Comparable<? super T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //打印数组元素
    public static <T extends Comparable<? super T>> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 5, 1, 3, 7, 7, 2, 8, 4, 6, 10};
        sort(arr);
        printArray(arr);
    }
}

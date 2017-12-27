package structure.quick.quicksort1;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 0:10
 * @desc:简单快速排序--对于基本有序的数组和重复元素较多的数组时间复杂度较高,存在不足需要改进
 **/
public class QuickSort1 {
    private QuickSort1() {
    }

    //通过分区,返回两个区的临界值
    private static int partition(Comparable[] arr, int l, int r) {
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

    //使用递归将数组分区
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
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
        int swapTimes = 100;
        int N=100;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        sort(arr1);
        SortTestHelper.printArray(arr1);
    }
}

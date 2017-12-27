package structure.sort_summary;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 11:19
 * @desc 选择排序
 **/
public class SelectionSort {
    private SelectionSort() {
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20, 0, 25);
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

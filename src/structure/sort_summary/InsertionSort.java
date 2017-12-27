package structure.sort_summary;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 11:18
 * @desc 直接插入排序
 **/
public class InsertionSort {
    private InsertionSort() {
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T base = arr[i];
            int j = i - 1;
            for (; j > 0 && base.compareTo(arr[j]) < 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = base;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 17, 10, 19, 13, 16, 18, 12, 14, 20};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

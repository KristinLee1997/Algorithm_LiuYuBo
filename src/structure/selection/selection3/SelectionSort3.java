package structure.selection.selection3;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/28 21:03
 * Goal:
 **/
public class SelectionSort3 {
    public SelectionSort3() {
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.printArray(arr);
        SelectionSort3.sort(arr);
        SortTestHelper.printArray(arr);
    }

}

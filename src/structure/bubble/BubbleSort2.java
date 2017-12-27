package structure.bubble;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 14:37
 * Goal:
 **/
public class BubbleSort2 {
    public BubbleSort2() {
    }

    public static void sort(Comparable[] arr) {

        for (int i = 0, pos = 0; i < arr.length; i = arr.length - pos) {
            pos = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    pos = j + 1;
                }
            }
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 6, 4, 2, 8};
        sort(arr);
        SortTestHelper.printArray(arr);
    }

}

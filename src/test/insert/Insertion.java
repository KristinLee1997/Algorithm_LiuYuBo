package test.insert;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 11:23
 * @desc
 **/
public class Insertion {
    /**
     * 直接插入排序--赋值版
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //交换数组中的两个元素
    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //打印数组
    public static <T extends Comparable<? super T>> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 7, 3, 10, 2, 8, 6, 4};
        insertionSort(arr);
        printArray(arr);
    }
}

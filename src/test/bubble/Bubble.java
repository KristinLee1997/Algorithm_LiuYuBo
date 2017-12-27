package test.bubble;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 10:44
 * @desc
 **/
public class Bubble {
    /**
     * 冒泡排序优化--标记符
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 0, pos = 0; i < arr.length; i = arr.length - pos) {
            pos = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    pos = j + 1;//说明pos后面的元素都已有序,不需要进行比较了
                }
            }
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<? super T>> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 9, 7, 3, 10, 2, 8, 6, 4};
        bubbleSort(arr);
        printArray(arr);
    }
}

package test.select;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 11:38
 * @desc
 **/
public class Selection {
    /**
     * 选择排序
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
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
        selectionSort(arr);
        printArray(arr);
    }
}

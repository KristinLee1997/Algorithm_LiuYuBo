package structure.sort_summary;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 11:57
 * @desc 冒泡排序
 **/
public class BubbleSort {
    private BubbleSort() {
    }

    //向大端冒泡--标志符
    public static <T extends Comparable<? super T>> void sort1(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    //向小端冒泡--标志符
    public static <T extends Comparable<? super T>> void sort2(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    //向大端冒泡--标记位(普通冒泡一次只能有一个元素排好序,记录标记位后,一次可以有多个排好序的元素)
    public static <T extends Comparable<? super T>> void sort3(T[] arr) {
        for (int i = 0, lastPosition = 0; i < arr.length - 1; i = arr.length - lastPosition - 1) {
            lastPosition = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    lastPosition = j;
                }
            }
        }
    }

    //鸡尾酒排序(来回排序)
    public static <T extends Comparable<? super T>> void sort4(T[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            for (int i = low; i < high; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                }
            }
            high--;
            for (int j = high; j > low; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
            low++;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 17, 10, 19, 13, 16, 18, 12, 14, 20};
        sort4(arr);
        SortTestHelper.printArray(arr);
    }
}

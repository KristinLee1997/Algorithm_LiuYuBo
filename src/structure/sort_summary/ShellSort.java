package structure.sort_summary;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 11:32
 * @desc 希尔排序
 **/
public class ShellSort {
    private ShellSort() {
    }

    //希尔排序--步长为2
    public static <T extends Comparable<? super T>> void sort1(T[] arr) {
        for (int len = arr.length, step = len / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                T base = arr[i];
                int j = i - step;
                for (; j > 0 && base.compareTo(arr[j]) < 0; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = base;
            }
        }
    }

    //希尔排序--步长为3
    public static <T extends Comparable<? super T>> void sort2(T[] arr) {
        int len = arr.length;
        int step = 1;
        while (step < len / 3) {
            step = step * 3 + 1;
        }
        for (; step >= 1; step /= 3) {
            for (int i = step; i < arr.length; i++) {
                T base = arr[i];
                int j = i - step;
                for (; j > 0 && base.compareTo(arr[j]) < 0; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = base;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 17, 10, 19, 13, 16, 18, 12, 14, 20};
        sort1(arr);
        SortTestHelper.printArray(arr);
    }
}

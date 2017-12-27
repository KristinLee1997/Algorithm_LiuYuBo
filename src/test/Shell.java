package test;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 17:36
 * @desc
 **/
public class Shell {
    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
        int n = arr.length;
        int step = 1;
        while (step < n / 3) {
            step = step * 3 + 1;
        }
        while (step >= 1) {
            for (int i = step; i < n; i++) {
                T temp = arr[i];
                int j = i;
                for (; j >= step && temp.compareTo(arr[j - step]) < 0; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

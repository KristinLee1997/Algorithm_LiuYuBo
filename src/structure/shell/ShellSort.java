package structure.shell;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 18:04
 * Goal:
 **/
public class ShellSort {
    public ShellSort() {
    }

    public static void sort(Comparable[] arr) {
        //数组长度 n
        int n = arr.length;
        //定义步长 h
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Comparable temp = arr[i];
                int j = i;
                for (; j >= h && temp.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }
            h /= 3;
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 1};
        ShellSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

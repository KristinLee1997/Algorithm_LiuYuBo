package structure.quick.problems;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 21:31
 * @desc 寻找数组中第k小的元素
 **/
public class FindTopKth {
    private FindTopKth() {
    }

    private static <T extends Comparable<? super T>> int partation(T[] arr, int left, int right) {
        T base = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (base.compareTo(arr[i]) > 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, j, left);
        return j;
    }

    private static <T extends Comparable<? super T>> T find(T[] arr, int left, int right, int k) {
        int p = partation(arr, left, right);
        if (p == k) {
            return arr[p];
        } else if (k < p) {
            return find(arr, left, p - 1, k);
        } else {
            return find(arr, p + 1, right, k);
        }
    }

    public static <T extends Comparable<? super T>> T find(T[] arr, int k) {
        return find(arr, 0, arr.length - 1, k - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 9, 7, 5, 11};
        System.out.println(find(arr, 1));//第1小的 //1
        System.out.println(find(arr, 2));//第2小的 //3
        System.out.println(find(arr, 3));//第3小的 //5
        System.out.println(find(arr, 4));//第4小的 //7
        System.out.println(find(arr, 5));//第5小的 //9
        System.out.println(find(arr, 6));//第6小的 //11
    }
}

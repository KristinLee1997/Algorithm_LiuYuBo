package structure.quick.problems;


import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 17:56
 * @desc 统计数组中有多少个逆序对
 **/
public class InversionCount {

    private InversionCount() {
    }

    private static <T extends Comparable<? super T>> int merge(T[] arr, int left, int mid, int right) {
        T[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) <= 0) {
                arr[k] = aux[i - left];
                i++;
            } else { //当mid左边大于右边时,mid-i+1长度都是逆序对
                arr[k] = aux[j - left];
                j++;
                res += (mid - i + 1);
            }
        }
        return res;
    }

    private static <T extends Comparable<? super T>> int sort(T[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int res1 = sort(arr, left, mid);    // 计算arr[left...mid]逆序对个数
        int res2 = sort(arr, mid + 1, right); //计算arr(mid...right]逆序对个数
        return res1 + res2 + merge(arr, left, mid, right);
    }

    public static <T extends Comparable<? super T>> int sort(T[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 1};
        int res = sort(arr);
        System.out.println(res);
    }
}

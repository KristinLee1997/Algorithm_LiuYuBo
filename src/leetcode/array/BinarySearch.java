package leetcode.array;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/30 21:29
 * @desc
 **/
public class BinarySearch {
    private static <T extends Comparable> int binarySearch1(T[] arr, int n, T target) {
        int low = 0, high = n - 1;//在[low,high]区间寻找target
        while (low <= high) {   //当l==r时,说明数组中只有一个元素,此时是有效的
            int mid = low + (high - low) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static <T extends Comparable> int binarySearch2(T[] arr, int n, T target) {
        int l = 0, r = n;//在区间[l...r)寻找target
        while (l < r) { //当l==r时,区间是无效的
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int res = BinarySearch.binarySearch2(arr, arr.length, 3);
        System.out.println(res);
    }
}

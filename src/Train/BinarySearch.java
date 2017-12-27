package Train;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/10 23:33
 * @desc
 **/
public class BinarySearch {
    public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low & high) + ((low ^ high) >> 1);
            if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else if (arr[mid].compareTo(target) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 3, 3, 3, 11, 13, 15, 17};
        int ret = binarySearch(arr, 3);
        System.out.println(ret);
    }
}
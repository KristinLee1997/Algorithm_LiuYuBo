package structure.binarytree.i_BinarySearchFloorAndCeil;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/5 15:34
 * @desc
 **/
public class BinarySearch {
    private BinarySearch() {
    }

    //二分查找,若存在返回元素角标,不存在返回-1
    public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid].compareTo(key) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //二分查找,若存在返回元素角标,不存在返回一个比key大的最大值的索引值
    public static <T extends Comparable<? super T>> int floor(T[] arr, T key) {
        int low = -1, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (arr[mid].compareTo(key) >= 0) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (low + 1 <= arr.length && arr[low + 1] == key) {
            return low + 1;
        }
        return low;
    }

    //二分查找,若存在返回元素角标,不存在返回一个比key大的最小值的索引值
    public static <T extends Comparable<? super T>> int ceil(T[] arr, T key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(key) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (high - 1 <= arr.length && arr[high] == key) {
            return high - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int pos = ceil(arr, 8);
        System.out.println(arr[pos]);
    }
}

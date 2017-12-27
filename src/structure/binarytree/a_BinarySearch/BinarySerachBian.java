package structure.binarytree.a_BinarySearch;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 10:01
 * @desc 二分搜索及其变种
 **/
public class BinarySerachBian {
    /**
     * 二分搜索
     *
     * @param arr
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low & high) + ((low ^ high) >> 1);//算符优先级:单目乘除位关系,逻辑三目后赋值
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 使用分治,查找元素在数组中第一次出现的位置,如果存在就返回相应的位置;如果不存在就返回-1;
     *
     * @param arr
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> int firstFind(T[] arr, T target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low & high) + ((low ^ high) >> 1);
            if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] == target) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 给定一个数组,和一个target,找出小于target的最接近target的值
     *
     * @param arr
     * @param terget
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> int findFloor(T[] arr, T terget) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low & high) + ((low ^ high) >> 1);
            if (arr[mid].compareTo(terget) >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 9, 9, 9, 9, 9, 9, 17};
        System.out.println(findFloor(arr, 9));
    }
}
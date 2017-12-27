package structure.binarytree.a_BinarySearch;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/4 15:23
 * @desc 二分查找(BinarySearch):在有序数组中查找是否存在key,如果存在,返回key的下标;如果不存在则返回-1
 **/
public class BinarySearch {
    private BinarySearch() {
    }

    //非递归二分查找
    public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T key) {
        int low = 0;
        int high = arr.length - 1;

        //查找arr[low...high]是否存在key
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(key) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(key) > 0) {  //arr[low...mid-1]是否存在key
                high = mid - 1;
            } else {    //arr[mid+1...high]是否存在key
                low = mid + 1;
            }
        }
        return -1;
    }


    /*对于mid溢出问题:
     * 1.long c=a+b;
     *   int mid=c/2;
     * 2.int mid=(a+b)>>>1;  //这是运用a+b不会溢出,是因为int是32位,但是第31位是符号为所以进行位运算时不会溢出
     * 3.int mid=a&b+(a^b)>>1;
     * 目的：两个二进制数，对应位置进行相加,求出每项的项系数，也就是每位结果。
     *  1.对应位相等，即同为1，或同为0
     *  2.对应为不同，其中一个为1，另一个为0
     *  假设先不考虑进位，a+b = 2110211.
     *  去找规律，发现，情况为2时，相加总为1，相当于异或运算。对于情况1，异或运算总为0.
     *  再去找规律，发现，情况为1时，两数相与的结果就是两数相加的一半。
     *
     *  a:1100110
     *  b:1010101
     *  ^:0110011         0   1   4   5    找到了这些项的系数
     *  &:1000100         2   3   6        找到了这些项的系数
     *  但上面这个与运算得出来的并不是真正的项系数，而是对应位置项系数的一般。所以 * 2后得
     *  :2000200(先不考虑进位)
     *  所以sum = (a & b) * 2 + (a ^ b)
     *  sum / 2 = (a & b) + (a ^ b) / 2
     * */

    //递归二分查找
    public static <T extends Comparable<? super T>> int binarySearch2(T[] arr, T key, int low, int high) {
        if (low > high) {
            return -1;  //如果没找到就返回-1
        }
        int mid = low + (high - low) / 2;   //数组中间下标,可能会溢出...
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid].compareTo(key) > 0) {
            return binarySearch2(arr, key, low, mid - 1);
        } else {
            return binarySearch2(arr, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
//        Integer[] arr = {1, 3, 5, 7, 9, 11, 13};
//        int ret = binarySearch2(arr, 8, 0, arr.length - 1);
//        System.out.println(ret);
        System.out.println((2147483647 + 5) >>> 1);
    }
}

package test.bucket;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 11:48
 * @desc
 **/
public class Bucket {
    /**
     * 桶排序
     * 给定元素范围可以使用桶排序,虽然空间复杂度大,但是时间复杂度仅为O(n)
     * 例题:请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
     * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
     * 测试样例：
     * [9,3,1,10]
     * 返回：6
     *
     * @param arr
     */
    public static void bucketSort(Integer[] arr) {
        Integer[] bucket = new Integer[21]; //针对于元素范围是0-20的元素
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 0, pos = 0; i < bucket.length; i++) { //这里虽然是双重循环,但时间复杂度并不是O(n^2),而是O(n)
            for (int j = bucket[i]; j > 0; j--) {
                arr[pos++] = i;
            }
        }
    }

    //获取相邻元素的最大差值
    public static Integer getMax(Integer[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = (arr[i + 1] - arr[i]) > max ? (arr[i + 1] - arr[i]) : max;
        }
        return max;
    }

    //交换数组中的两个元素
    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //打印数组
    public static <T extends Comparable<? super T>> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 3, 1, 10};
        bucketSort(arr);
        System.out.println(getMax(arr));
    }
}

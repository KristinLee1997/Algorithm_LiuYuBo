package structure.bucket;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/9 14:37
 * @desc 桶排序
 **/
public class BucketSort {
    public static void bucketSort(int[] arr) {
        int[] bucket = new int[20];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 0, pos = 0; i < bucket.length; i++) {
            for (int j = bucket[i]; j > 0; j--) {
                arr[pos++] = i;
            }
        }
    }

    /**
     * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
     * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
     * 测试样例：
     * [9,3,1,10],4
     * 返回：6
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > max) {
                max = arr[i + 1] - arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 10};
        bucketSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int max = getMax(arr);
        System.out.println(max);
    }
}

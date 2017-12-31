package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/30 22:01
 * @desc Leetcode283题:给定一个数组,写一个函数,将数组中的所有0挪到数组的末尾,而维持其他所有非
 * 0元素的相对位置.举例 input:[0,1,0,3,12] output:[1,3,12,0,0]
 **/
public class MoveZeros {
    public static void moveZeroes1(int[] nums) {
        int[] nonZeroElements = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements[count] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nonZeroElements[count] = 0;
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nonZeroElements[i];
        }
    }

    public static void moveZeroes2(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[size] = nums[i];
                size++;
            }
        }
        for (int i = size; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (i != k) {   //如果数组中没有0,就不需要交换
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes3(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

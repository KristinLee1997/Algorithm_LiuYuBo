package leetcode.array;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/31 9:54
 * @desc Leetcode27:给定一个数组nums和一个数值val,将数组中所有等于val的元素删除,并返回剩余的元素个数
 * 例如: input: nums[3,2,2,3],vals=3
 * output:2(且nums中前两个元素为2)
 **/
public class RemoveElements {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {  //如果数组中没有val,就不需要交换
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }
        return k;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int res = removeElement(nums, 3);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

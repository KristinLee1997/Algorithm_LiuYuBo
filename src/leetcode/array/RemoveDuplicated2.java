package leetcode.array;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/31 10:52
 * @desc Leetcode 80:给定一个有序数组,对数组中的元素去重,使得原数组的每个元素最多保留两个.返回去重后数组的长度值
 * 例如: input:[1,1,1,2,2,3] output:5(且nums的前5个元素为1,1,2,2,3)
 **/
public class RemoveDuplicated2 {
    public static int removeDuplicates(int[] nums) { //1,1,1,2,2,3,3,4,4,4,5
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] > nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = RemoveDuplicated2.removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

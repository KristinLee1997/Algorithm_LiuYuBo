package leetcode.array;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/31 10:49
 * @desc Leetcode26:给定一个有序数组,对数组中的元素去重,使得原数组的每个元素只有一个.返回去重后的数组的长度值
 * input:[1,1,2] output:2(且前两个元素是1,2)  1,2,2,2,3,3,4,5
 **/
public class RemoveDuplicated {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int res = RemoveDuplicated.removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

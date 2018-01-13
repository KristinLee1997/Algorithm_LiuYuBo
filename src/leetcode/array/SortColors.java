package leetcode.array;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/31 14:30
 * @desc 给定一个有n个元素的数组, 数组中元素的取值只有0, 1, 2三种可能, 为这个数组排序
 **/
public class SortColors {
    //计数排序:时间复杂度O(n) 空间复杂度:O(1)
    public void sortColors1(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        int index = 0;
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < count[k]; i++) {
                nums[index++] = k;
            }
        }
    }

    //三路快排
    public void sortColors2(int[] nums) {
        int zero = -1; // nums[0...zero]=0
    }

    public static void main(String[] ags) {
        int[] nums = {0, 1, 2, 2, 1, 0, 2, 1};

        SortColors s = new SortColors();
        s.sortColors1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
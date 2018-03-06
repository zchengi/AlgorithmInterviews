package org.three.five;

import java.util.Arrays;

/**
 * LeetCode 75 Sort Color
 * <p>
 * 三路快排
 * 对整个数组只遍历了一遍
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/6 19:50
 */
public class Solution2 {
    public int[] sortColors(int[] nums) {

        // nums[0...zero] = 0
        int zero = -1;
        // nums[two...n-1] = 2
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, i++, ++zero);
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                i++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 2, 2, 1, 0, 1, 2, 0, 2};

        System.out.println(Arrays.toString(new Solution2().sortColors(nums)));
    }
}

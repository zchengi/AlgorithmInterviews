package org.three.three;

import java.util.ArrayList;

/**
 * LeetCode 283. Move Zeros
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/2/27 22:36
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        // 将 nums 中所有非0元素放入 nonZeroElements 中
        for (int num : nums) {
            if (num != 0) nonZeroElements.add(num);
        }

        // 将 nonZeroElements 的所有元素一次放入到 nums 开始的位置
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        // 将 nums 剩余的位置放置为0
        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        new Solution().moveZeroes(arr);

        for (int num : arr) {
            System.out.println(num + " ");
        }
    }
}

package org.four.four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 001. Two Sum
 * <p>
 * 查找表实现
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/18 19:21
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                return new int[]{i, record.get(complement)};
            }

            record.put(nums[i], i);
        }

        throw new IllegalArgumentException("The input has no solution.");
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}

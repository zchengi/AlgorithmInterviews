package nine.eight;

import java.util.Arrays;

/**
 * LeetCode 300. Longest Increasing SubSequence
 * <p>
 * 记忆化搜索
 * <p>
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(n)
 *
 * @author cheng
 *         2018/12/28 18:32
 */
public class Solution1 {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getMaxLength(nums, i));
        }

        return res;
    }

    /**
     * 以 nums[index] 为结尾的最长上升子序列的长度
     */
    private int getMaxLength(int[] nums, int index) {

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }

        return memo[index] = res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution1().lengthOfLIS(nums));
    }
}

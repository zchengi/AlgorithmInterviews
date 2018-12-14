package nine.four;

import java.util.Arrays;

/**
 * LeetCode 198. House Robber
 * <p>
 * 记忆化搜索
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/14 12:18
 */
public class Solution1 {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index...nums.size()) 这个范围的所有房子
     */
    private int tryRob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 0;

        for (int i = index; i < nums.length; i++) {
            // 计算最大抢劫到的金额
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }

        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution1().rob(nums));
    }
}

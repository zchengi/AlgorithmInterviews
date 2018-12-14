package nine.four;

/**
 * LeetCode 198. House Robber
 * <p>
 * 动态规划，改变状态定义，优化转移方程
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/14 12:55
 */
public class Solution8 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        int[] memo = new int[n];
        memo[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 或者当前房子放弃，考虑 [0...i-1] 的所有房子
            // 或者抢劫当前的房子，考虑 [0...i-2] 的所有房子
            memo[i] = Math.max(memo[i - 1], nums[i] + (i - 2 >= 0 ? memo[i - 2] : 0));
        }

        return memo[n - 1];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution8().rob(nums));
    }
}

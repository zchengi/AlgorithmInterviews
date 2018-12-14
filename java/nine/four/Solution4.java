package nine.four;

/**
 * LeetCode 198. House Robber
 * <p>
 * 动态规划，改变状态定义
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/14 12:43
 */
public class Solution4 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        int[] memo = new int[n];
        memo[0] = nums[0];

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
            }
        }

        return memo[n - 1];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution4().rob(nums));
    }
}

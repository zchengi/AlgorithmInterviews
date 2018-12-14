package nine.four;

/**
 * LeetCode 198. House Robber
 * <p>
 * 动态规划
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/14 12:29
 */
public class Solution2 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution2().rob(nums));
    }
}

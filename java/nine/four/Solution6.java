package nine.four;

/**
 * LeetCode 198. House Robber
 * <p>
 * 动态规划，优化状态转移
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/14 12:50
 */
public class Solution6 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            // 或者当前房子放弃，从下一个房子开始考虑
            // 或者抢劫当前房子，从 i+2 以后的房子开始考虑
            memo[i] = Math.max(memo[i + 1], nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        }

        return memo[0];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution6().rob(nums));
    }
}

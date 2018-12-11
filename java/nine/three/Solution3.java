package nine.three;

/**
 * LeetCode 343. Integer Break
 * 动态规划
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/11 15:51
 */
public class Solution3 {

    public int integerBreak(int n) {

        // dp[i] 表示将数字i分割(至少分割两部分)后得到的最大乘积
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解 dp[i]
            for (int j = 1; j <= i - 1; j++) {
                // j + (i - j)
                // 不分割i，分割为 i 与 j，分割i后再分割j
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution3().integerBreak(n));
    }
}

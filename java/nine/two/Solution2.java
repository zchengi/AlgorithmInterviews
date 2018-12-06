package nine.two;

import java.util.Arrays;

/**
 * LeetCode 070.  Climbing Stairs
 * <p>
 * 动态规划
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/6 10:45
 */
public class Solution2 {

    private int[] memo;

    public int climbStairs(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[1] = 1;
        memo[0] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution2().climbStairs(n));
    }
}

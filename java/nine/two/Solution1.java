package nine.two;

import java.util.Arrays;

/**
 * LeetCode 070.  Climbing Stairs
 * <p>
 * 递归法
 *
 * @author cheng
 *         2018/12/6 10:31
 */
public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution1().climbStairs(n));
    }
}

package nine.three;

/**
 * LeetCode 343. Integer Break
 * 记忆化搜索
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/11 15:45
 */
public class Solution2 {

    private int[] memo;

    public int integerBreak(int n) {

        memo = new int[n + 1];
        return breakInteger(n);
    }

    /**
     * 将 n 进行分割(至少分割两部分)，可以获得的最大乘积
     */
    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            // i + ( n - 1)
            // 参数1：不分割最大值，参数2：i * 剩余部分不分割，参数3： i * 分割剩余部分
            // res：得到最大值
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution2().integerBreak(n));
    }
}

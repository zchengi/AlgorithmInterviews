package nine.five;

/**
 * 背包问题
 * <p>
 * 动态规划
 * 时间复杂度：O(n*C)，其中n为物品个数，C为背包容积
 * 空间复杂度：O(n*C)
 *
 * @author cheng
 *         2018/12/19 15:00
 */
public class Solution2 {

    public int knapsack2(int[] w, int[] v, int C) {

        if (w == null || v == null || w.length != v.length) {
            throw new IllegalArgumentException("Invalid w or v");
        }

        if (C < 0) {
            throw new IllegalArgumentException("C must be greater or equals zero");
        }

        int n = w.length;
        if (n == 0 || C == 0) {
            return 0;
        }

        int[][] memo = new int[n][C + 1];

        // 第一行
        for (int j = 0; j <= C; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Solution2().knapsack2(w, v, C));
    }
}

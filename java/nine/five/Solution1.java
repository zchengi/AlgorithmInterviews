package nine.five;

import java.util.Arrays;

/**
 * 背包问题
 * <p>
 * 记忆化搜索
 * 时间复杂度：O(n*C)，其中n为物品个数，C为背包容积
 * 空间复杂度：O(n*C)
 *
 * @author cheng
 *         2018/12/19 13:59
 */
public class Solution1 {

    private int[][] memo;

    public int knapsack1(int[] w, int[] v, int C) {

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

        memo = new int[n][C + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return bestValue(w, v, n - 1, C);
    }

    /**
     * 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
     */
    private int bestValue(int[] w, int[] v, int index, int c) {

        if (c <= 0 || index < 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;

        return res;
    }

    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Solution1().knapsack1(w, v, C));
    }
}

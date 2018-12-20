package nine.six;

/**
 * 0-1背包问题
 * 动态规划改进
 * <p>
 * 时间复杂度：O(n*C)，其中n为物品个数，C为背包容积
 * 空间复杂度：O(C)，实际使用了C的额外空间
 *
 * @author cheng
 *         2018/12/20 12:02
 */
public class Solution2 {

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

        int[] memo = new int[C + 1];

        // 第一行
        for (int j = 0; j <= C; j++) {
            memo[j] = j >= w[0] ? v[0] : 0;
        }

        // 第 i 行
        for (int i = 1; i < n; i++) {
            // 第 j 列，j为剩余容量，必须大于当前容量
            for (int j = C; j >= w[i]; j--) {
                // 上一列最优价值 与 当前列价值 + 剩余容量最优价值
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }

        return memo[C];
    }

    public static void main(String[] args) {

        int[] w = {1, 10, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Solution2().knapsack1(w, v, C));
    }
}

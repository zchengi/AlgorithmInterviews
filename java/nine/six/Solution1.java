package nine.six;

/**
 * 0-1背包问题
 * 动态规划改进：滚动数组
 * <p>
 * 时间复杂度：O(n*C)，其中n为物品个数，C为背包容积
 * 空间复杂度：O(C)，实际使用了2*C的额外空间
 *
 * @author cheng
 *         2018/12/20 11:43
 */
public class Solution1 {

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

        // memo[0] 记录 i 为偶数的行
        // memo[1] 记录 i 为奇数的行
        int[][] memo = new int[2][C + 1];

        // 第一行
        for (int j = 0; j <= C; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                // 第 i 行在 i%2 的位置
                // 第 i-1 行在 (i-1)%2 的位置
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }

        return memo[(n - 1) % 2][C];
    }

    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Solution1().knapsack1(w, v, C));

    }
}

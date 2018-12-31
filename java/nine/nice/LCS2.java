package nine.nice;

/**
 * LCS 问题
 * <p>
 * 动态规划
 * <p>
 * 时间复杂度: O(len(s1)*len(s2))
 * 空间复杂度: O(len(s1)*len(s2))
 *
 * @author cheng
 *         2018/12/31 20:01
 */
public class LCS2 {

    public String lcs(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m][n];
        // 对 memo 的第0行初始化
        for (int j = 0; j < n; j++) {
            if (s1.charAt(0) == s2.charAt(j)) {
                for (int k = j; k < n; k++) {
                    memo[0][k] = 1;
                }

                break;
            }
        }

        // 动态规划的过程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        // 通过 memo 反向求解 s1 和 s2 的最长公共子序列
        m = s1.length() - 1;
        n = s2.length() - 1;

        StringBuilder res = new StringBuilder();
        while (m >= 0 && n >= 0) {
            if (s1.charAt(m) == s2.charAt(n)) {
                res.insert(0, s1.charAt(m));
                m--;
                n--;
            } else if (m == 0) {
                n--;
            } else if (n == 0) {
                m--;
            } else {
                if (memo[m - 1][n] > memo[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {

        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println((new LCS2()).lcs(s1, s2));

        s1 = "AAACCGTGAGTTATTCGTTCTAGAA";
        s2 = "CACCCCTAAGGTACCTTTGGTTC";
        System.out.println((new LCS2()).lcs(s1, s2));
    }
}

package nine.nice;

import java.util.Arrays;

/**
 * LCS 问题
 * <p>
 * 穷举出所有可能性
 * <p>
 * 时间复杂度: O(len(s1)*len(s2))
 * 空间复杂度: O(len(s1)*len(s2))
 *
 * @author cheng
 *         2018/12/31 19:19
 */
public class LCS1 {

    /**
     * 记录 s1[0...m] 和 s2[0...n] 的最长公共子序列
     */
    private int[][] memo;

    public String lcs(String s1, String s2) {

        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("s1 and s2 can not be null.");
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        lcs(s1, s2, s1.length() - 1, s2.length() - 1);
        return getLCS(s1, s2);
    }

    /**
     * 求 s1[0...m] 和 s2[0...n] 的最长公共子序列的长度
     */
    private int lcs(String s1, String s2, int m, int n) {

        if (m < 0 || n < 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        int res;
        if (s1.charAt(m) == s2.charAt(n)) {
            // s1[m] == s2[n]
            res = 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            // max( lcs(s1[m-1], s2[n]) , lcs(s1[m][n-1]) )
            res = Math.max(lcs(s1, s2, m - 1, n),
                    lcs(s1, s2, m, n - 1));
        }
        memo[m][n] = res;

        return res;
    }

    /**
     * 通过 memo 反向求解 s1 和 s2 的最长公共子序列
     */
    private String getLCS(String s1, String s2) {

        int m = s1.length() - 1;
        int n = s2.length() - 1;

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
        System.out.println((new LCS1()).lcs(s1, s2));

        s1 = "AAACCGTGAGTTATTCGTTCTAGAA";
        s2 = "CACCCCTAAGGTACCTTTGGTTC";
        System.out.println((new LCS1()).lcs(s1, s2));
    }
}

package nine.three;

/**
 * LeetCode 343. Integer Break
 * 暴力搜索(Time Limit Exceeded)
 * <p>
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/11 15:33
 */
public class Solution1 {


    public int integerBreak(int n) {
        return breakInteger(n);
    }

    /**
     * 将 n 进行分割(至少分割两部分)，可以获得的最大乘积
     */
    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            // i + ( n - 1)
            // 参数1：不分割最大值，参数2：i * 剩余部分不分割，参数3： i * 分割剩余部分
            // res：得到最大值
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution1().integerBreak(n));
    }
}

package nine.two;

/**
 * LeetCode 070.  Climbing Stairs
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/6 10:52
 */
public class Solution3 {

    public int climbStairs(int n) {

        int[] res = new int[n + 1 > 3 ? n + 1 : 3];

        res[0] = 0;
        res[1] = 1;
        res[2] = 2;

        if (n < 2) {
            return res[n];
        }

        for (int i = 3; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution3().climbStairs(n));
    }
}

package ten.one;

import java.util.Arrays;

/**
 * LeetCode 455. Assign Cookies
 * <p>
 * 先尝试满足最不贪心的小朋友
 * <p>
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2019/1/11 16:59
 */
public class Solution2 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi =  0;
        int si = 0;
        int res = 0;

        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                res++;
                gi++;
            }
            si++;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(new Solution2().findContentChildren(g, s));

        g = new int[]{1, 2};
        s = new int[]{1, 2, 3};
        System.out.println((new Solution2()).findContentChildren(g, s));
    }
}

package four.five;

import java.util.HashMap;

/**
 * LeetCode 454. 4Sum II
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 *
 * @author cheng
 *         2018/3/19 19:38
 */
public class Solution1 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A == null || B == null || C == null || D == null) {
            throw new IllegalArgumentException("Illegal argument.");
        }

        // 存储 数组 C 和 D 的所有元素的所有组合
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        int res = 0;
        for (int a : A) {
            for (int b : B) {
                if (map.containsKey(-a - b)) {
                    res += map.get(-a - b);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution1()).fourSumCount(a, b, c, d));
    }
}

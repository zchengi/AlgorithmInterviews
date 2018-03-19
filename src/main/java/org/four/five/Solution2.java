package org.four.five;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 454. 4Sum II
 * <p>
 * 对 Solution1 的代码优化：使用 Java8 的新特性
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 *
 * @author cheng
 *         2018/3/19 19:38
 */
public class Solution2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A == null || B == null || C == null || D == null) {
            throw new IllegalArgumentException("Illegal argument.");
        }

        // 存储 数组 C 和 D 的所有元素的所有组合
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -c - d;
                res += map.getOrDefault(sum, 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution2()).fourSumCount(a, b, c, d));
    }
}

package org.three.six;

import java.util.Arrays;

/**
 * LeetCode 167. Two Sum II - Input Array is Sorted
 * <p>
 * 暴力枚举法
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/7 21:06
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers.");
        }


        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        throw new IllegalStateException("The input has no solution.");
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 6};
        int target = 10;

        System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));
    }
}

package org.four.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 349. Intersection of Two Arrays
 * <p>
 * set 的使用
 * 时间复杂度: O(len(nums1)+len(nums2))
 * 空间复杂度: O(len(nums1))
 *
 * @author cheng
 *         2018/3/16 20:56
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> record = new HashSet<Integer>();
        for (int num : nums1) {
            record.add(num);
        }

        Set<Integer> resultSet = new HashSet<Integer>();
        for (int num : nums2) {
            if (record.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution().intersection(nums1, nums2)));
    }
}

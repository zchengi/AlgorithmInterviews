package org.four.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 350. Intersection of Two Arrays II
 * <p>
 * 另一种解法
 *
 * @author cheng
 *         2018/3/16 21:22
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Queue<Integer> intersections = new LinkedList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersections.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] ret = new int[intersections.size()];
        int index = 0;
        for (int num : intersections) {
            ret[index++] = num;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution2().intersect(nums1, nums2)));
    }
}

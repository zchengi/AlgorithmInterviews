package org.four.eight;

import java.util.TreeSet;

/**
 * LeetCode 220. Contains Duplicate III
 * <p>
 * 这个问题的测试数据在使用 int 进行加减运算的时候会溢出
 * 所有使用 long
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(k)
 *
 * @author cheng
 *         2018/3/23 15:20
 */
public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0){
            return false;
        }

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            // 这里判断 record 中是否存在一个数大于 nums[i] - t，
            // 且这个值小于等于 nums[i] + t 的情况下返回 true
            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }

            record.add((long) nums[i]);

            // 规定 record 的最大范围为 k+1
            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println(new Solution1().containsNearbyAlmostDuplicate(nums, k, t));
    }
}

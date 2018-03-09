package org.three.seven;

/**
 * LeetCode 209. Minimum Size SubArray Sum
 * <p>
 * 二分搜素
 * 扩展了 Solution2 的方法。对于每一个l，可以使用二分搜索法搜索 r
 * <p>
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/9 21:16
 */
public class Solution5 {
    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Arguments.");
        }

        // sums[i] 存放 nums[0...i-1] 的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int res = nums.length + 1;
        for (int l = 0; l < nums.length - 1; l++) {
            // Java类库中没有内置 lowerBound 方法
            // 需要自己实现一个基于二分搜素的 lowerBound
            int r = lowerBound(sums, sums[l] + s);
            if (r != sums.length) {
                res = Math.min(res, r - l);
            }
        }

        if (res == nums.length + 1) return 0;
        return res;
    }

    /**
     * 在有序数组 nums 中寻找大于等于 target 的最小值
     * 如果没有(nums数组中的所有值都小于target)，则返回 nums.length
     */
    private int lowerBound(int[] nums, int target) {

        if (nums == null) {
            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");
        }

        // 在nums[l...r)的范围里寻找解
        int l = 0, r = nums.length;
        while (l != r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Solution5().minSubArrayLen(s, nums));
    }
}

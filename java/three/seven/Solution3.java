package three.seven;

/**
 * LeetCode 209. Minimum Size SubArray Sum
 * <p>
 * 滑动窗口的思路
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/9 21:09
 */
public class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Arguments.");
        }

        // nums[l...r] 为滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        // 窗口的左边界在数组范围内,则循环继续
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                // r 已经到头或者 sum >= s
                sum -= nums[l++];
            }

            if (sum >= s) res = Math.min(res, r - l + 1);
        }

        if (res == nums.length + 1) return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Solution3().minSubArrayLen(s, nums));
    }
}

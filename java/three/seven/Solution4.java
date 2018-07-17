package three.seven;

/**
 * LeetCode 209. Minimum Size SubArray Sum
 * <p>
 * 另外一个滑动窗口的实现, 仅供参考
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/9 21:12
 */
public class Solution4 {
    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Arguments.");
        }

        // nums[l...r] 为滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        // 窗口的右边界无法继续扩展了, 则循环继续
        while (r + 1 < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            }

            if (sum >= s) res = Math.min(res, r - l + 1);

            while (l < nums.length && sum >= s) {
                sum -= nums[l++];
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == nums.length + 1) return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Solution4().minSubArrayLen(s, nums));
    }
}

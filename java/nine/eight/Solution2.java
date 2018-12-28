package nine.eight;

/**
 * LeetCode 300. Longest Increasing SubSequence
 * <p>
 * 动态规划
 * <p>
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(n)
 *
 * @author cheng
 *         2018/12/28 18:53
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length + 1];
        memo[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, 1 + memo[j]);
                }
            }

            memo[i] = max;
        }

        int max = -1;
        for (int li : memo) {
            max = Math.max(max, li);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution2().lengthOfLIS(nums));
    }
}

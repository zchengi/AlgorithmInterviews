package nine.seven;

/**
 * LeetCode 416. Partition Equal Subset Sum
 *
 * @author cheng
 *         2018/12/21 17:09
 */
public class Solution3 {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        return dfs(nums, nums.length - 1, sum / 2, 0);
    }

    private boolean dfs(int[] nums, int index, int sum, int cur) {

        if (index < 0 || nums[index] > sum || cur > sum) {
            return false;
        }

        if (cur == sum || nums[index] == sum) {
            return true;
        }

        return dfs(nums, index - 1, sum, cur + nums[index]) ||
                dfs(nums, index - 1, sum, cur);
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println(new Solution3().canPartition(nums));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(new Solution3().canPartition(nums2));
    }

}

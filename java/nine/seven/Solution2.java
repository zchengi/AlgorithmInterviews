package nine.seven;

/**
 * LeetCode 416. Partition Equal Subset Sum
 * <p>
 * 动态规划
 * 时间复杂度: O(len(nums) * O(sum(nums)))
 * 空间复杂度: O(len(nums) * O(sum(nums)))
 *
 * @author cheng
 *         2018/12/21 16:39
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length;
        // 计算是否能够填满容量为 C 的背包，如果可以，则返回 true，否则返回 false
        int C = sum / 2;

        boolean[] memo = new boolean[C + 1];
        for (int i = 0; i <= C; i++) {
            memo[i] = nums[0] == i;
        }

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = C; j >= num; j--) {
                memo[j] = memo[j] || memo[j - num];
            }
        }

        return memo[C];
    }


    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println(new Solution2().canPartition(nums));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(new Solution2().canPartition(nums2));
    }

}

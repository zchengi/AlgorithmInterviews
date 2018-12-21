package nine.seven;

/**
 * LeetCode 416. Partition Equal Subset Sum
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(len(nums) * O(sum(nums)))
 * 空间复杂度: O(len(nums) * O(sum(nums)))
 *
 * @author cheng
 *         2018/12/21 16:19
 */
public class Solution1 {

    /**
     * memo[i][c] 表示使用索引为 [0...i] 的这些元素，是否可以完全填充一个容量为c的背包
     * 0 表示未计算，-1 表示 不可以填充，1 表示可以填充
     */
    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        memo = new int[nums.length][sum / 2 + 1];
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    /**
     * 使用 nums[0...index], 是否可以完全填充一个容量为 sum 的背包
     * 如果可以另一半也找到了，即返回 true，否则返回 false
     */
    private boolean tryPartition(int[] nums, int index, int sum) {

        if (sum == 0) {
            return true;
        }

        if (index < 0 || sum < 0) {
            return false;
        }

        if (memo[index][sum] != 0) {
            return memo[index][sum] == 1;
        }

        memo[index][sum] = tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index]) ? 1 : -1;

        return memo[index][sum] == 1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println(new Solution1().canPartition(nums));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(new Solution1().canPartition(nums2));
    }
}

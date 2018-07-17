package four.seven;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 219. Contains Duplicate II
 * <p>
 * 滑动窗口 + 查找表
 * 优化 Solution1
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 *
 * @author cheng
 *         2018/3/23 15:00
 */
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return false;
        }
        if (k <= 0) {
            return false;
        }

        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);
            if (record.size() > k) {
                record.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {-1, -1};
        int k = 1;
        System.out.println(new Solution2().containsNearbyDuplicate(nums, k));
    }
}

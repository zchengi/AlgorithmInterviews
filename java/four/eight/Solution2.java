package four.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 220. Contains Duplicate III
 * <p>
 * 这个问题的测试数据在使用 int 进行加减运算的时候会溢出
 * 所有使用 long
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 *
 * @author cheng
 *         2018/3/23 15:34
 */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }

        Map<Integer, Integer> bucket = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int id = getId(nums[i], w);
            if (bucket.containsKey(id)) {
                return true;
            } else if (bucket.containsKey(id - 1) && Math.abs(bucket.get(id - 1) - nums[i]) < w) {
                return true;
            } else if (bucket.containsKey(id + 1) && Math.abs(bucket.get(id + 1) - nums[i]) < w) {
                return true;
            }

            bucket.put(id, nums[i]);
            if (i >= k) {
                bucket.remove(getId(nums[i - k], w));
            }
        }

        return false;
    }

    private int getId(int i, int w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }


    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println(new Solution2().containsNearbyAlmostDuplicate(nums, k, t));
    }
}

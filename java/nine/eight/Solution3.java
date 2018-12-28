package nine.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 300. Longest Increasing SubSequence
 * <p>
 * Binary Search + DP
 *
 * @author cheng
 *         2018/12/28 19:00
 */
public class Solution3 {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 从小到大 记录最长序列的每个元素
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // 如果当前 num 大最后一个元素
            if (result.size() == 0 || num > result.get(result.size() - 1)) {
                // 直接将当前元素添加到末尾
                result.add(num);
            } else {
                // 二分搜索
                int left = 0;
                int right = result.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    // 判断索引为 mid 的元素是否小于 num
                    if (result.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                // 将当前 num 插入到对应的位置
                result.set(right, num);
            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution3().lengthOfLIS(nums));
    }
}

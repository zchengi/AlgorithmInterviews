package three.five;

import java.util.Arrays;

/**
 * LeetCode 75 Sort Color
 * <p>
 * 计数排序
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1), k为元素的取值范围
 *
 * @author cheng
 *         2018/3/6 19:41
 */
public class Solution1 {
    public int[] sortColors(int[] nums) {

        // 存放 0, 1, 2 三个元素的频率
        int[] count = new int[3];
        for (int num : nums) {
            assert num >= 0 && num <= 2;
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 2, 2, 1, 0, 1, 2, 0, 2};

        System.out.println(Arrays.toString(new Solution1().sortColors(nums)));
    }
}

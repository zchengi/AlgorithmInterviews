package three.six;

import java.util.Arrays;

/**
 * LeetCode 167. Two Sum II - Input Array is Sorted
 * <p>
 * 对撞指针
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/7 21:29
 */
public class Solution3 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers.");
        }

        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }

        throw new IllegalStateException("The input has no solution.");
    }


    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 6};
        int target = 10;

        System.out.println(Arrays.toString(new Solution3().twoSum(nums, target)));
    }
}

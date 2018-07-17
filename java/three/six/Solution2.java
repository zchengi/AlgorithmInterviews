package three.six;

import java.util.Arrays;

/**
 * LeetCode 167. Two Sum II - Input Array is Sorted
 * <p>
 * 二分查找法
 * <p>
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/7 21:18
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers.");
        }

        for (int i = 0; i < numbers.length; i++) {

            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }

        throw new IllegalStateException("The input has no solution.");
    }

    private int binarySearch(int[] nums, int l, int r, int target) {

        if (l < 0 || l > nums.length) {
            throw new IllegalArgumentException("'l' is out of bound.");
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) l = mid + 1;
            else if (target < nums[mid]) r = mid - 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 6};
        int target = 10;

        System.out.println(Arrays.toString(new Solution2().twoSum(nums, target)));
    }
}

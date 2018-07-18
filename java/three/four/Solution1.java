package three.four;

/**
 * 优化思路1：原地(in place)解决该问题
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/2/27 22:47
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        // nums中，[0...k)的元素均为非0元素
        int k = 0;

        // 遍历到第i个元素后，保证[0...i]中的所有非0元素
        // 都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // 将nums剩余的位置放置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        new Solution1().moveZeroes(arr);

        for (int num : arr) {
            System.out.println(num + " ");
        }
    }
}

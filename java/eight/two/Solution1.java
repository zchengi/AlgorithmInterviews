package eight.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 046. Permutations
 *
 * @author cheng
 *         2018/11/13 22:13
 */
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    /**
     * p 中保存了一个有 count-1 个元素的排列
     * 向这个排列的末尾添加第 count 个元素，获得一个有 count 个元素的排列
     *
     * @param nums
     * @param count
     * @param p
     */
    private void generatePermutation(int[] nums, int count, LinkedList<Integer> p) {

        if (count == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);

                generatePermutation(nums, count + 1, p);

                used[i] = false;
                p.removeLast();
            }
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution1().permute(nums));
    }
}

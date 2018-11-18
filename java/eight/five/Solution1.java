package eight.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 039. Combination Sum
 *
 * @author cheng
 *         2018/11/18 17:47
 */
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> cur) {

        for (; index < candidates.length; index++) {
            int candidate = candidates[index];
            if (target == candidate) {
                cur.add(candidate);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return;
            }

            if (target > candidate) {
                cur.add(candidate);
                combinationSum(candidates, target - candidate, index, cur);
                cur.remove(cur.size() - 1);
            }

            if (target < candidate) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution1().combinationSum(candidates, target));
    }
}

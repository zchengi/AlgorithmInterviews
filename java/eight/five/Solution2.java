package eight.five;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 039. Combination Sum
 *
 * @author cheng
 *         2018/11/18 18:16
 */
public class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        combinationSum(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> res) {

        if (target < 0 || index == candidates.length) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }


        for (; index < candidates.length; index++) {
            cur.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], index, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution2().combinationSum(candidates, target));
    }
}

package eight.four;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 077. Combinations
 * <p>
 * 时间复杂度: O(n^k)
 * 空间复杂度: O(k)
 *
 * @author cheng
 *         2018/11/16 12:07
 */
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        generateCombinations(arr, 0, new ArrayList<>(), k);
        return res;
    }

    /**
     * 求解 list(n, k)，当前已经找到的组合存子啊 list 中，需要从 start 开始搜索新元素
     */
    private void generateCombinations(int[] arr, int start, List<Integer> list, int k) {

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (start == arr.length) {
            return;
        }

        list.add(arr[start]);
        generateCombinations(arr, start + 1, list, k);
        list.remove(new Integer(arr[start]));
        generateCombinations(arr, start + 1, list, k);
    }

    public static void main(String[] args) {

        int n = 4, k = 2;
        System.out.println(new Solution1().combine(n, k));
    }
}

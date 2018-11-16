package eight.five;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 077. Combinations
 * <p>
 * 时间复杂度: O(n^k)
 * 空间复杂度: O(k)
 *
 * @author cheng
 *         2018/11/16 12:38
 */
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        generateCombinations(n, 1, k, new ArrayList<>());
        return res;
    }

    /**
     * 求解 list(n, k)，当前已经找到的组合存子啊 list 中，需要从 start 开始搜索新元素
     */
    private void generateCombinations(int n, int start, int k, List<Integer> list) {

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 还有 k - list.size() 个空位，所以 [i...n] 中至少要有 k - list.size() 个元素
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombinations(n, i + 1, k, list);
            list.remove(new Integer(i));
        }
    }

    public static void main(String[] args) {

        int n = 4, k = 2;
        System.out.println(new Solution2().combine(n, k));
    }
}

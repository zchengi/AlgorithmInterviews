package six.five;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * LeetCode 279. Perfect Squares
 * <p>
 * 使用 visited 数组，记录每一个入队元素（进一步优化）
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/6/27 20:08
 */
public class Solution3 {
    public int numSquares(int n) {

        if (n == 0) {
            return 0;
        }

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    queue.addLast(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        throw new IllegalArgumentException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println(new Solution3().numSquares(12));
        System.out.println(new Solution3().numSquares(13));
    }
}

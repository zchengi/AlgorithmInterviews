package six.five;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * LeetCode 279. Perfect Squares
 * <p>
 * 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
 * <p>
 * 时间复杂度: O(2^n)
 * 空间复杂度: O(2^n)
 *
 * @author cheng
 *         2018/6/27 20:00
 */
public class Solution1 {
    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                queue.addLast(new Pair<>(num - i * i, step + 1));
            }
        }

        throw new IllegalArgumentException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println(new Solution1().numSquares(12));
        System.out.println(new Solution1().numSquares(13));
    }
}

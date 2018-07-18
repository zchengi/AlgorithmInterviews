package four.six;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 447. Number of Boomerangs
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 * <p>
 * 代码优化：减少一层循环
 *
 * @author cheng
 *         2018/3/21 21:17
 */
public class Solution3 {
    public int numberOfBoomerangs(int[][] points) {

        int count = 0;
        Map<Integer, Integer> record = new HashMap<>();
        for (int[] point1 : points) {
            // record 中存储点 i 到所有其他点的距离出现的频次
            for (int[] point2 : points) {
                int distance = dis(point1, point2);

                Integer value = record.get(distance);
                if (value != null) {
                    count += 2 * value;
                    record.put(distance, value + 1);
                } else {
                    record.put(distance, 1);
                }
            }
            record.clear();
        }

        return count;
    }

    private int dis(int[] point1, int[] point2) {
        int x = point1[0] - point2[0];
        int y = point1[1] - point2[1];
        return x * x + y * y;
    }

    public static void main(String[] args) {

        int[][] arr = {{0, 0}, {1, 0}, {2, 0}, {2, 0}, {2, 0}};
        System.out.println(new Solution3().numberOfBoomerangs(arr));
    }
}

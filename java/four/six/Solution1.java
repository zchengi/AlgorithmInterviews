package four.six;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 447. Number of Boomerangs
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/3/21 20:54
 */
public class Solution1 {
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // record 中存储点 i 到所有其他点的距离出现的频次
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算距离时不进行开根运算，以保证精度
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)) {
                        record.put(dis, record.get(dis) + 1);
                    } else {
                        record.put(dis, 1);
                    }
                }
            }

            for (int k : record.values()) {
                res += k * (k - 1);
            }
            record.clear();
        }

        return res;
    }

    private int dis(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] arr = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new Solution1().numberOfBoomerangs(arr));
    }
}

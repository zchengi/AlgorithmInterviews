package ten.two;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 435. Non-overlapping Intervals
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2019/1/14 11:39
 */
public class Solution3 {
    public int eraseOverlapIntervals(Interval[] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        int res = 0;
        int prev = 0;

        for (int cur = 1; cur < intervals.length; cur++) {
            // 判断当前区间与前一个区间是否有重叠
            if (intervals[prev].end > intervals[cur].start) {
                // 删除区间大的
                if (intervals[prev].end > intervals[cur].end) {
                    prev = cur;
                }
                res++;
            } else {
                prev = cur;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Interval[] intervals = {new Interval(1, 2), new Interval(2, 3),
                new Interval(3, 4), new Interval(1, 3)};
        System.out.println(new Solution3().eraseOverlapIntervals(intervals));
    }
}


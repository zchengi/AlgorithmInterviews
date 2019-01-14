package ten.two;

import java.util.Arrays;

/**
 * LeetCode 435. Non-overlapping Intervals
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2019/1/14 11:30
 */
public class Solution2 {
    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });

        int res = 1;
        int prev = 0;
        for (int cur = 1; cur < intervals.length; cur++) {
            if (intervals[cur].start >= intervals[prev].end) {
                res++;
                prev = cur;
            }
        }

        return intervals.length - res;
    }

    public static void main(String[] args) {

        Interval[] intervals = {new Interval(1, 2), new Interval(2, 3),
                new Interval(3, 4), new Interval(1, 3)};
        System.out.println(new Solution2().eraseOverlapIntervals(intervals));
    }
}


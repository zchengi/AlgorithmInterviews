package ten.two;

import java.util.Arrays;

/**
 * LeetCode 435. Non-overlapping Intervals
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2019/1/14 11:14
 */
public class Solution1 {
    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        });

        // memo[i] 表示使用 intervals[0...i] 的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < intervals.length; i++) {
            // memo[i]
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return intervals.length - res;
    }

    public static void main(String[] args) {

        Interval[] intervals = {new Interval(1, 2), new Interval(2, 3),
                new Interval(3, 4), new Interval(1, 3)};
        System.out.println(new Solution1().eraseOverlapIntervals(intervals));
    }
}

class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
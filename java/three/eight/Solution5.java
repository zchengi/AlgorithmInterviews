package three.eight;

import java.util.Arrays;

/**
 * LeetCode 003. Longest Substring Without Repeating Characters
 * <p>
 * 滑动窗口
 * 其中使用 last[c] 保存字符 c 上一次出现的的位置，用于在右边界发现重复字符时，快速移动左边界
 * 使用这种方法，时间复杂度依然为O(n)，但是只需要动 r 指针，实际上对整个 s 只遍历了一次
 * 相较而言，之前的方法，需要移动 l 和 r 两个指针，相对于对 s 遍历了两次
 * <p>
 * 时间复杂度：O(len(s))
 * 空间复杂度：O(len(charset))
 *
 * @author cheng
 *         2018/3/10 23:30
 */
public class Solution5 {
    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[256];
        Arrays.fill(last, -1);

        int l = 0, r = -1;
        int res = 0;

        while (r + 1 < s.length()) {

            r++;
            // 如果当前 s[r] 出现过，将 l 移动到 s[r] 第一次出现的位置再 + 1
            if (last[s.charAt(r)] != -1) {
                l = Math.max(l, last[s.charAt(r)] + 1);
            }

            // 如果当前 s[r] 未出现过，则判断  r - l + 1 与当前 res 的值并取最大
            res = Math.max(res, r - l + 1);
            // 将当前 s[r] 出现的位置 r 记录到数组中
            last[s.charAt(r)] = r;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution5().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution5().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution5().lengthOfLongestSubstring(""));
    }
}

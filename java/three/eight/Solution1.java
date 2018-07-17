package three.eight;

/**
 * LeetCode 003. Longest Substring Without Repeating Characters
 * <p>
 * 滑动窗口
 * <p>
 * 时间复杂度：O(len(s))
 * 空间复杂度：O(len(charset))
 *
 * @author cheng
 *         2018/3/10 19:47
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {

        // 记录每个字符出现的频率
        int[] freq = new int[256];

        // 滑动窗口为s[l...r]
        int l = 0, r = -1;
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到 l == s.size(); r == s.size() - 1 这个空窗口截至
        // 在每次循环里逐渐改变窗口，维护 freq，并记录当前窗口中是否找到了一个新的最优值

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                // 当前字母 (r + 1) 没出现过，将它的出现频率 + 1
                freq[s.charAt(++r)]++;
            } else {
                // 这里的执行逻辑：每次判断当前字母出现过，然后将 l++ 更新 l 的 freq，r 的值不变

                // r 已经到头 || freq[s.charAt(r + 1)] == 1
                freq[s.charAt(l++)]--; // 先执行 freq[s.charAt(l)] -- ，然后 l++
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution1().lengthOfLongestSubstring(""));
    }
}

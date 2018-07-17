package three.eight;

/**
 * LeetCode 003. Longest Substring Without Repeating Characters
 * <p>
 * 滑动窗口另一个实现，仅做参考
 * <p>
 * 时间复杂度：O(len(s))
 * 空间复杂度：O(len(charset))
 *
 * @author cheng
 *         2018/3/10 23:15
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        // 记录每个字符出现的频率
        int[] freq = new int[256];

        int l = 0, r = -1;
        int res = 0;

        // 循环终止条件可以是 r + 1 < s.length(), 因为 r 到头的时候，不可能出现比当前 res 更大的值
        while (r + 1 < s.length()) {
            while (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            }

            res = Math.max(res, r - l + 1);

            if (r + 1 < s.length()) {
                freq[s.charAt(++r)]++;
                assert freq[s.charAt(r)] == 2;
                while (l <= r && freq[s.charAt(r)] == 2) {
                    freq[s.charAt(l++)]--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution3().lengthOfLongestSubstring(""));
    }
}

package six.one;

/**
 * LeetCode 20 Valid Parentheses
 * <p>
 * 使用 char数组 实现
 *
 * @author cheng
 *         2018/4/24 19:15
 */
public class Solution3 {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int stackPos = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || c == '}' || c == ']') {
                if (stackPos == -1 || stack[stackPos] != c) {
                    return false;
                }

                --stackPos;
            } else if (c == '(' || c == '{' || c == '[') {
                ++stackPos;
                stack[stackPos] = (char) ((1 + c) | 1);
            }
        }

        return stackPos == -1;
    }

    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(new Solution3().isValid(s));
    }
}

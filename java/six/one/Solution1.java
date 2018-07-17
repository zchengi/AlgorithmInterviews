package six.one;

import java.util.Stack;

/**
 * LeetCode 20 Valid Parentheses
 * <p>
 * 使用一个 栈 和两个 char数组 判断
 *
 * @author cheng
 *         2018/4/24 18:42
 */
public class Solution1 {
    public boolean isValid(String s) {

        char[] left = {'{', '[', '('};
        char[] right = {'}', ']', ')'};

        Stack<Character> stack = new Stack<>();

        // 判断是否是左括号
        boolean flag = false;
        for (char c : s.toCharArray()) {

            for (char c1 : left) {
                if (c1 == c) {
                    stack.add(c);
                    flag = true;
                    break;
                }
            }

            // 如果是左括号，结束本次循环进入下次循环
            if (flag) {
                flag = false;
                continue;
            }

            // 如果当前栈为空，则证明不合法
            if (stack.isEmpty()) {
                return false;
            }

            // 下面三个分别判断当前栈种的元素是否与 c 匹配

            if (c == right[0] && left[0] == stack.peek()) {
                stack.pop();
                continue;
            }
            if (c == right[1] && left[1] == stack.peek()) {
                stack.pop();
                continue;
            }
            if (c == right[2] && left[2] == stack.peek()) {
                stack.pop();
                continue;
            }

            return false;
        }

        // 如果栈不为空，则证明不匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(new Solution1().isValid(s));
    }
}

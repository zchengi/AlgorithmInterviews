package org.six.one;

import java.util.Stack;

/**
 * LeetCode 20 Valid Parentheses
 * <p>
 * 另一种实现，不使用额外的 char数组 空间
 *
 * @author cheng
 *         2018/4/24 19:02
 */
public class Solution2 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char lChar = stack.pop();
                char match;

                if (c == ')') {
                    match = '(';
                } else if (c == ']') {
                    match = '[';
                } else {
                    match = '{';
                }

                if (lChar != match) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(new Solution2().isValid(s));
    }
}

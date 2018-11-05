package eight.one;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 017. Letter Combinations of a Phone Number
 * <p>
 * 时间复杂度: O(2^len(s))
 * 空间复杂度: O(len(s))
 *
 * @author cheng
 *         2018/11/5 11:42
 */
public class Solution1 {

    private String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res = new ArrayList<>();


    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        findCombinations(digits, 0, "");
        return res;
    }

    /**
     * s 中保存了此时 digits[0...index-1] 翻译得到的一个字母字符串
     * 寻找和 digits[index] 匹配的字母，获得 digits[0...index] 翻译得到的解
     *
     * @param digits
     * @param index
     * @param s
     */
    private void findCombinations(String digits, int index, String s) {

        System.out.println(index + " : " + s);
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        char c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = "
                    + c + ", use " + letters.charAt(i));
            findCombinations(digits, index + 1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "]" + c + " complete, return");

    }

    public static void main(String[] args) {

        String digits = "23";
        System.out.println(new Solution1().letterCombinations(digits));
    }
}

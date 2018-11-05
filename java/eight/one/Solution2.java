package eight.one;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 017. Letter Combinations of a Phone Number
 *
 * @author cheng
 *         2018/11/5 12:30
 */
public class Solution2 {
    public List<String> letterCombinations(String digits) {


        LinkedList<String> res = new LinkedList<>();
        String[] letterMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.isEmpty()) {
            return res;
        }

        res.add("");
        while (res.peek().length() != digits.length()) {
            String remove = res.remove();
            String map = letterMap[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                res.addLast(remove + c);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String digits = "23";
        System.out.println(new Solution2().letterCombinations(digits));
    }
}

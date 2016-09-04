package LeetCode.backTracking.LetterCombinationsOfAPhoneNumber_17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a digit string, return all possible letter combinations that the number could represent.
*/
// Solution with no recursion
// https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue
public class Solution {
    private String[][] letters = {{}, {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    // n=digits.length;
    // Time complexity O(4^n): depth=n, branches=4(4 letters in the button maximum) => complexity or recursion tree = branches^depth
    // space complexity O(n) - because of recursion we have n nested recursion calls.
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        ArrayList<String> current = new ArrayList<>();
        comb(digits, 0, current, res);
        return res;
    }

    private void comb(String digits, int index, ArrayList<String> current, List<String> res) {
        if (index == digits.length()) {
            res.add(String.join("", current));
            return;
        }
        int d = digits.charAt(index) - '0';
        String[] lets = letters[d];
        for (String s : lets) {
            current.add(s);
            comb(digits, index+1, current, res);
            current.remove(current.size()-1);
        }
    }
}
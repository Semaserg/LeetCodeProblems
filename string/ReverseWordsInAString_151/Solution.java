package LeetCode.string.ReverseWordsInAString_151;

import java.util.ArrayList;
import java.util.List;

/*
151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class Solution {
    // C++ in place solution
    // https://discuss.leetcode.com/topic/5319/c-solution-in-place-runtime-o-n-memory-o-1
    // idea: reverse each words one-by-one, and then reverse whole string.
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        List<String> words = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == ' ') {
                if (right > left) {
                    words.add(0, s.substring(left, right));
                }
                right++;
                left = right;
            } else {
                right++;
            }
        }
        if (right > left) words.add(0, s.substring(left, right));
        return String.join(" ", words);
    }
}
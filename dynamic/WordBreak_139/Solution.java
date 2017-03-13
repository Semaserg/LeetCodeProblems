package LeetCode.dynamic.WordBreak_139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
139. Word Break
https://leetcode.com/problems/word-break/?tab=Description

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary
words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
// Time complexity ???, space complexity ???.
public class Solution {
    // My stupid solution - Time limit exceeded
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null) throw new IllegalArgumentException("ex1");
        if (wordDict == null) throw new IllegalArgumentException("ex2");
        if (s.length() == 0) return true;
        if (wordDict.size() == 0) return false;
        HashSet<String> dict = new HashSet<>(wordDict);
        return dp(s,0,1,dict);
    }

    // Time limit exceeded, looks like n^n time complexity
    private boolean dp(String s, int left, int right, HashSet<String> dict) {
        if (left >= s.length()) return true;
        if (right > s.length()) return false; // double-check
        //for (int index = right; index<=s.length(); index++) {
        for (int index = s.length(); index>=right; index--) {
            String word = s.substring(left, index);
            if (dict.contains(word)) {
                boolean isSuccess = dp(s, index, index+1, dict);
                if (isSuccess) return true;
            }
        }
        return false;
    }

    // Time complexity O(n^2) (not included the substring), including substring should be O(n^3)
    // Remember that substring has O(n) complexity
    // https://discuss.leetcode.com/topic/7299/c-dynamic-programming-simple-and-fast-solution-4ms-with-optimization
    // https://discuss.leetcode.com/topic/2545/a-solution-using-bfs/2 - BFS approach
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) throw new IllegalArgumentException("ex1");
        if (wordDict == null) throw new IllegalArgumentException("ex2");
        if (s.length() == 0) return true;
        if (wordDict.size() == 0) return false;
        HashSet<String> dict = new HashSet<>(wordDict);

        //  set to true if a valid word (word sequence) ends in some index
        // 0 - true, because empty word is valid and ends there
        // s.len - indicates is valid word ends here => does s end with a valid word.
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int right = 1; right <= s.length(); right++) {
            for (int left = right-1; left >= 0; left--) {
                if (dp[left] == true) {
                    String word = s.substring(left, right);
                    if (dict.contains(word)) dp[right] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

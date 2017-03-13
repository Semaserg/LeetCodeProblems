package LeetCode.backTracking.WordBreak2_140;

import java.util.*;

/*
140. Word Break II
https://leetcode.com/problems/word-break-ii/?tab=Description

 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 add spaces in s to construct a sentence where each word is a valid dictionary word.
 You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    // My stupid solution - Time limit exceeded.
    // Looks like O(n^n) time complexity.
    public List<String> wordBreak1(String s, List<String> wordDict) {
        if (s == null || wordDict == null) throw new IllegalArgumentException("ex");
        HashSet<String> dictionary = new HashSet<>(wordDict);

        ArrayList<String> result = new ArrayList<>();
        if (s.length() == 0) return result;

        StringBuilder builder = new StringBuilder();
        dp(s, 0, 1, builder, result, dictionary);

        return result;
    }

    private void dp(String s, int left, int right, StringBuilder builder, ArrayList<String> result, HashSet<String> dictionary) {
        int len = s.length();
        if (left >= len) {
            result.add(builder.substring(0, builder.length()-1).toString());
        }
        if (right > len) return;
        for (int index=right; index <= len; index++) {
            String word = s.substring(left, index);
            if (dictionary.contains(word)) {
                int nextPartLength = word.length() + 1; // because of " "
                builder.append(word + " ");
                dp(s, index, index+1, builder, result, dictionary);
                builder.delete(builder.length()-nextPartLength, builder.length());
            }
        }
    }

    // https://discuss.leetcode.com/topic/27855/my-concise-java-solution-based-on-memorized-dfs
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) throw new IllegalArgumentException("ex");
        HashSet<String> dictionary = new HashSet<>(wordDict);
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        return dp(s, dictionary, map);
    }

    private List<String> dp(String s, HashSet<String> dict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> possibleNextWords = dp(s.substring(word.length()), dict, map);
                for (String nextWord : possibleNextWords) {
                    String phrase = (nextWord.length() > 0) ? word + " " + nextWord : word;
                    res.add(phrase);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

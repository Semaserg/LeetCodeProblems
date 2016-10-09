package LeetCode.hashtable.SubstringWithConcatenationOfAllWords_30;

import java.util.*;

/*
30. Substring with Concatenation of All Words
https://leetcode.com/problems/substring-with-concatenation-of-all-words/

You are given a string, s, and a list of words, words,
that are all of the same length. Find all starting indices
of substring(s) in s that is a concatenation of each word
in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

// startPortionLen - SPL
// words - WL
// words[0].length() - L
// Time complexity O(SPL*WL*L), space complexity O(2*WL*L) => O(WL*L).
// https://discuss.leetcode.com/topic/6432/simple-java-solution-with-two-pointers-and-map
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) return res;

        // words array can has repetitions of the words
        // so we should calc the reps number for each word.
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words) {
            if (!map.containsKey(w)) map.put(w, 1);
            else map.put(w, map.get(w)+1);
        }
        int l = words[0].length();
        // only in this portion owe could start the search
        // because the rest of the s has not enough space to have all the words;
        int startPortionLen = s.length() - words.length * l; // SPL
        for (int i=0; i<=startPortionLen; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            for (int j=0; j<words.length; j++) {
                int wordStart = i + j*l, wordEnd = i + j*l + l;
                String word = s.substring(wordStart, wordEnd);
                System.out.println(word);
                if (copy.containsKey(word)) {
                    if (copy.get(word) == 1) copy.remove(word);
                    else copy.put(word, copy.get(word)-1);
                } else {
                    break;
                }
            }
            if (copy.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }
}
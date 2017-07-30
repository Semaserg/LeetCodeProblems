package LeetCode.string.LongestSubstringWithAtMostTwoDistinctCharacters_159;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
159. Longest Substring with At Most Two Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) throw new IllegalArgumentException("ex");
        if (s.length() < 3) return s.length();

        int l = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // <char, counter>
        for (int r=0; r<s.length(); r++) {
            char rc = s.charAt(r);
            int rCharCnt = map.getOrDefault(rc, 0);
            map.put(rc, rCharCnt+1);

            if (isValid(map)) {
                maxLen = Math.max(maxLen, r-l+1);
            }

            while (!isValid(map)) {
                char lc = s.charAt(l);
                int lCharCnt = map.get(lc);
                if (lCharCnt == 1) {
                    map.remove(lc);
                } else {
                    map.put(lc, lCharCnt-1);
                }
                l++;
            }
        }
        return maxLen;
    }

    private boolean isValid(Map<Character, Integer> map) {
        return map.size() < 3;
    }
}
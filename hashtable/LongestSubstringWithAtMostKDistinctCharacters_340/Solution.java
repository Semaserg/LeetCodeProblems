package LeetCode.hashtable.LongestSubstringWithAtMostKDistinctCharacters_340;

import java.util.HashMap;
import java.util.Map;

/**
 340. Longest Substring with At Most K Distinct Characters
 https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/#/description

 Given a string, find the length of the longest substring T that
 contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
*/
public class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    private void addChar(char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c)+1);
        } else {
            map.put(c, 1);
        }
    }

    private void removeChar(char c) {
        if (!map.containsKey(c))return;
        if (map.get(c) > 1) {
            map.put(c, map.get(c)-1);
        } else {
            map.remove(c);
        }
    }

    private boolean isValid(int k) {
        return map.size() <= k;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        int left=0, right=0, max=0;
        while (right<s.length()) {
            char rightCurr = s.charAt(right);
            addChar(rightCurr);
            if (isValid(k)) {
                right++;
                max = Math.max(max, right - left);
                continue;
            }
            while (!isValid(k)) {
                char leftCurr = s.charAt(left);
                removeChar(leftCurr);
                left++;
            }
            right++;
        }
        return max;
    }
}
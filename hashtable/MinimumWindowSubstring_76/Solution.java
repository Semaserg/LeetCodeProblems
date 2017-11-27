package LeetCode.hashtable.MinimumWindowSubstring_76;

import java.util.*;

/*
76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class Solution {
    //https://discuss.leetcode.com/topic/21143/java-solution-using-two-pointers-hashmap
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        // map to keep counters for each chat in t. Chars could repeat in t.
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);

        int count = 0, left=0, minLeft = 0, minLen = s.length()+1;
        // move right bound every time
        // decrease char counter from the map, if current char exists in t.
        for (int right = 0; right < s.length(); right++ ) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                // we should update the counter of char in any case
                // map.get(rightChar) - it could be less then 0, and this is ok.
                // Because we could found the same char more then one time.
                map.put(rightChar, map.get(rightChar)-1);
                if (map.get(rightChar) >= 0) count++;
            }

            // if we found all the chars from t, start moving left till we lost some of the chars from t.
            // In this moment we leave the "while" loop and continue moving the right bound till we get all the
            // chars from t again.
            while (count == t.length()) {
                if (right-left+1 < minLen) {
                    minLeft = left;
                    minLen = right-left+1;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar)+1);
                    if (map.get(leftChar) > 0) count--;
                }
                left++;
                //System.out.println(s.substring(minLeft, minLeft+minLen));
            }
        }
        if(minLen > s.length())
        {
            return "";
        }
        return s.substring(minLeft, minLeft+minLen);
    }
}
package LeetCode.hashtable.IsomorphicStrings_205;

import java.util.HashMap;
import java.util.Map;

/*
205. Isomorphic Strings
https://leetcode.com/problems/isomorphic-strings/

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/
// Time complexity O(n), space complexity O(n).
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            Character first = s.charAt(i);
            Character second = t.charAt(i);
            if (!map.containsKey(first) && !map.containsValue(second)) {
                map.put(first, second);
            } else if (map.get(first) != second) {
                return false;
            }
        }
        return true;
    }
}
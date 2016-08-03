package LeetCode.hashtable.ValidAnagram_242;

import java.util.HashMap;

/*
242. Valid Anagram
https://leetcode.com/problems/valid-anagram/

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
https://discuss.leetcode.com/topic/20303/2-c-solutions-with-explanations - set of solutions.
- sort both strings and compare the result.
- use char[26] array to store the chars counters. Check the all counters are 0.
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            Character currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) map.put(currentChar, map.get(currentChar)+1);
            else map.put(currentChar, 1);
        }
        for (int j=0; j<len; j++) {
            Character currentChar = t.charAt(j);
            if (map.containsKey(currentChar)) {
                int nextCounter = map.get(currentChar)-1;
                if (nextCounter <= 0) map.remove(currentChar);
                else map.put(currentChar, nextCounter);
            }
            else return false;
        }
        return map.keySet().size() == 0 ? true : false;
    }
}
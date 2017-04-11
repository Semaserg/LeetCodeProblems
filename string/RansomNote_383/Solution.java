package LeetCode.string.RansomNote_383;

import java.util.HashMap;

/*
https://leetcode.com/problems/ransom-note/#/description
383. Ransom Note

Given an arbitrary ransom note string and another string containing letters
 from all the magazines, write a function that will return true if the
 ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int charCnt = map.getOrDefault(c, 0);
            if (charCnt == 0) return false;
            else {
                map.put(c, charCnt-1);
            }
        }
        return true;
    }
}
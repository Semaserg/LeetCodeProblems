package LeetCode.string.OneEditDistance_161;

import java.util.HashMap;

/*
https://leetcode.com/problems/one-edit-distance/description/
161. One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.
It means Livenshtain distance == 1, but exchanges is 1 operation.

*/
// https://discuss.leetcode.com/topic/22435/easy-understood-java-solution
// https://discuss.leetcode.com/topic/30308/my-clear-java-solution-with-explanation
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null) throw new IllegalArgumentException("ex");
        if (t == null) throw new IllegalArgumentException("ex");

        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen) return isOneEditDistance(t, s); // the first one should be always smaller

        if (tLen - sLen > 1) return false; // if edit distance more than 1 -> return false. t and s should have no more than 1 diff in length

        // looking for the first different char
        int i = 0;
        while (i<sLen && s.charAt(i) == t.charAt(i)) i++; // after this while i - is the index of the first different character
        if (i == sLen) {
            return sLen != tLen; // if (sLen == tLen) strings are equal => edit distance == 0 => return false
        }

        if (sLen == tLen) {
            return s.substring(i+1).equals(t.substring(i+1)); // skip different char and compare rest of the string
        }
        return s.substring(i).equals(t.substring(i+1)); //  skip one character from the bigger string and compare rest of the string
    }
}
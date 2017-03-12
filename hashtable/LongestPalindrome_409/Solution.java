package LeetCode.hashtable.LongestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

/**
409. Longest Palindrome
https://leetcode.com/problems/longest-palindrome/?tab=Description

Given a string which consists of lowercase or uppercase letters,
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.
*/
// https://discuss.leetcode.com/topic/61298/easy-to-understand-accepted-solution-with-explanation
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("ex");
        if (s.length() < 2) return s.length();

        HashMap<Character, Integer> charCountersMap = new HashMap<>();
        for(char current : s.toCharArray()) {
            int counter = charCountersMap.getOrDefault(current, 0);
            charCountersMap.put(current, counter+1);
        }

        int maxPalindromeLen = 0;
        boolean hasOdd = false;
        for (char current : charCountersMap.keySet()) {
            int counter = charCountersMap.get(current);
            if (counter % 2 == 0) {
                maxPalindromeLen += counter;
            } else {
                maxPalindromeLen += counter - 1; // if counter == 3, we can use 2 chars to build the palindrome
                hasOdd = true; // if we have at least one odd, it means we can use 1 char in the middle of palindrome
            }
        }
        maxPalindromeLen = (hasOdd) ? maxPalindromeLen+1 : maxPalindromeLen;
        return maxPalindromeLen;
    }
}
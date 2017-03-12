package LeetCode.hashtable.PalindromePermutation_266;

import java.util.HashMap;

/*
266. Palindrome Permutation
https://leetcode.com/problems/palindrome-permutation/?tab=Description

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome.
How about character which occurs odd number of times?
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("ex");
        if (s.length() < 2) return true;

        HashMap<Character, Integer> charCounters = new HashMap<>();
        for (char current : s.toCharArray()) {
            int counter = charCounters.getOrDefault(current, 0);
            charCounters.put(current, counter+1);
        }
        boolean hasOdd = false;
        for(int counter : charCounters.values()) {
            if (counter%2 == 1) {
                if (hasOdd == true) return false; // already have one odd character
                else hasOdd = true;
            }
        }
        return true;
    }
}
package LeetCode.string.LongestPalindromicSubstring_5;

import java.util.Arrays;

/*
5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
*/
public class Solution {
    // O(n^2) solution
    // https://habrahabr.ru/post/276195/
    // http://e-maxx.ru/algo/palindromes_count
    // http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) return s;
        int start = 0, end = 0;
        for (int i=1; i<s.length(); i++) {
            int left = i-1, right = i+1; // with char in the middle, like "aba" - - palindroms of odd length
            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if (end - start < right - left) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }

        for (int i=1; i<s.length(); i++) {
            int left = i-1, right = i; // with no char in the middle, like "aa" - palindroms of even length
            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if (end - start < right - left) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end+1);
    }

    // Manacher algorithm - O(n)
    // http://e-maxx.ru/algo/palindromes_count
    // Most of the people in Leetcode use O(n^2) solition
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int left = 0, right = -1;
        int[] oddPalindromeMaxLen = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            // int symmetricIndex = left + right - i; - so we can use this data. For instance:
            // symmetricIndex is 'a' in 'bab' - s0 it oddPalindromeMaxLen[symmetricIndex]=3,
            // so k is the center of 'bab' as well, and oddPalindromeMaxLen[k] should be at least 3, or greater.
            // If symmetricIndex is 'b' in 'abc' - oddPalindromeMaxLen[symmetricIndex]=1. =>
            // oddPalindromeMaxLen[k] = 1;
            // right-i - to cut the palindrome if we are close to the right edge.
            int len = (i>right ? 0 : Math.min(oddPalindromeMaxLen[left + right - i], right-i)) + 1;
            //int localLeft = i-currLen, localRight = i+currLen;
            while (i-len >= 0 && i+len < s.length() && s.charAt(i-len) == s.charAt(i+len)) {
                len++;
            }
            oddPalindromeMaxLen[i] = len;
            len--;

            // We should keep the left & right of the most right palindrome.
            if (i+len > right) {
                right = i+len;
                left = i-len;
            }
        }

        int index = 0;
        // find longest palindrome
        for (int i=0; i<oddPalindromeMaxLen.length; i++) {
            if (oddPalindromeMaxLen[i] > oddPalindromeMaxLen[index]) {
                index = i;
            }
        }
        int start = index - oddPalindromeMaxLen[index] + 1;
        int end = index + oddPalindromeMaxLen[index];
        String s1 = s.substring(start, end);

        left = 0; right = -1;
        int[] evenPalindromeMaxLen = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            int len = (i>right ? 0 : Math.min(evenPalindromeMaxLen[left + right - i + 1], right - i + 1)) + 1;
            while (i-len >= 0 && i+len-1 < s.length() && s.charAt(i-len) == s.charAt(i+len-1)) {
                len++;
            }
            len--;
            evenPalindromeMaxLen[i] = len;

            // We should keep the left & right of the most right palindrome.
            if (i+len-1 > right) {
                right = i+len-1;
                left = i-len;
            }
        }

        index = 0;
        // find longest palindrome
        for (int i=0; i<evenPalindromeMaxLen.length; i++) {
            if (evenPalindromeMaxLen[i] > evenPalindromeMaxLen[index]) {
                index = i;
            }
        }
        start = index - evenPalindromeMaxLen[index];
        end = index + evenPalindromeMaxLen[index];
        String s2 = s.substring(start, end);
        return s1.length() > s2.length() ? s1 : s2;
    }
}
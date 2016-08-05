package LeetCode.string.ValidPalindrome_125;

import java.util.Stack;

/*
125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    // Time complexity O(n)
    public boolean isPalindrome1(String s) {
        if (s.length() < 2) return true;
        int i=0, j=s.length()-1;
        while (i<j) {
            while (i<s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j>=0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            // if string contains only spec chars ",.:*" we should treat string as palindrome.
            // in such case we should skip all of the chars, thus i=len, j=-1.
            if (i>=s.length() && j<0) return true;
            else if (i>=s.length() && j>=0) return false;
            else if (i<s.length() && j<0) return false;

            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    // Time complexity O(n)
    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int i=0, j=s.length()-1;
        while (i<j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if (!Character.isLetterOrDigit(s.charAt(j))) j--;
            else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
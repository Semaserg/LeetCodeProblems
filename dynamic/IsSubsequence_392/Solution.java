package LeetCode.dynamic.IsSubsequence_392;


/*
392. Is Subsequence
https://leetcode.com/problems/is-subsequence/

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters
in both s and t. t is potentially a very long (length ~= 500,000)
string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the
original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
and you want to check one by one to see if T has its subsequence.
In this scenario, how would you change your code?
*/

import java.util.ArrayList;
import java.util.HashMap;

// Time complexity ???, space complexity ???.
public class Solution {

    // Time complexity O(t.len)
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int j=0;
        for (int i=0; i<t.length(); i++) {
            if (j == s.length()) return true;
            if (s.charAt(j) == t.charAt(i)) j++;
        }
        return j == s.length();
    }

    private HashMap<Character, ArrayList<Integer>> scanRes = new HashMap<>();

    // For the case of huge t, with a lot of incoming S
    // Go throw the t and create a HashMap<Char, List<int>> - char - list of positions.
    private void scan(String t) {
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (!scanRes.containsKey(c)) scanRes.put(c, new ArrayList<>());
            scanRes.get(c).add(i);
        }
    }

    // https://discuss.leetcode.com/topic/57718/easy-to-understand-binary-search-solution
    public boolean isSubsequence1(String s, String t) {
        scan(t); // call this in constructor instead of each time

        if (s.length() > t.length()) return false;

        int prevIndex = -1;
        for (char c : s.toCharArray()) {
            int nextIndex = binarySearch(c, prevIndex);
            if (nextIndex < prevIndex) return false;
        }
        return true;
    }

    // use binary search to find the smallest index of current char
    // which is greater then index of prev char.
    // we can use binary search because of each list in scanRes is sorted.
    // TODO: FIX THIS BINARY SEARCH, SOME PROBLEM WITH BIG S.
    private int binarySearch(char curr, int prevCharIndex) {
        ArrayList<Integer> charPosList = scanRes.get(curr);
        if (charPosList == null) return -1;

        int lo = 0, hi = charPosList.size()-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (charPosList.get(mid) == prevCharIndex) {
                // check if mid is the last item in the list (mid == charPosList.size()-1)
                // then return -1, because of no greater index in this array
                return (mid == charPosList.size()-1) ? -1 : charPosList.get(mid + 1);
            }
            if (charPosList.get(mid) > prevCharIndex) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (charPosList.get(hi) > prevCharIndex) return charPosList.get(hi);
        if (hi < charPosList.size()-1) return charPosList.get(hi+1);
        return -1;
    }
}
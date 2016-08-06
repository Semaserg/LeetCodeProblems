package LeetCode.string.LongestCommonPrefix_14;

/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    // Time complexity O(m*n)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.length() == 0) return "";
        }
        return prefix;
    }

    private String getPrefix(String first, String second) {
        int len = Math.min(first.length(), second.length());
        if (len == 0) return "";
        for(int i=0; i<len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return (i>0) ? first.substring(0,i) : "";
            }
        }
        return first.substring(0,len);
    }
}

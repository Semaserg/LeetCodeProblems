package LeetCode.dynamic.WildcardMatching_44;

/**
 44. Wildcard Matching
 https://leetcode.com/problems/wildcard-matching/description/

 Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
*/
class Solution {
    // http://www.geeksforgeeks.org/wildcard-pattern-matching/
    // https://www.youtube.com/watch?v=3ZDZ-N0EPV0
    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("ex");
        if (s.length() == 0 && p.length() == 0) return true;
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        // set first row
        for (int i=1; i<n; i++) {
            int charIndex = i - 1;
            dp[0][i] = dp[0][i-1] && p.charAt(charIndex) == '*';
        }
        // first column is false by default excluding dp[0][0].
        for (int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                int sInd = i-1, pInd = j-1;
                if (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(pInd) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

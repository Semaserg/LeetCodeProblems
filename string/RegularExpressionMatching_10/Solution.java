package LeetCode.string.RegularExpressionMatching_10;

import java.util.HashMap;

/*
https://leetcode.com/problems/regular-expression-matching/#/destrCharription
10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("ex");
        int m = s.length()+1, n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // fill first row
        for (int i=1; i<n; i++) {
            int pCurr = p.charAt(i-1);
            if (i >= 2 && pCurr == '*') {
                dp[0][i] = dp[0][i-2]; // not prev, but prev-prev, because * can just remove the character
            }
        }
        // first col is false by default excluding dp[0][0]
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                int sInd = i-1, pInd = j-1;
                if (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(pInd) == '*') {
                    if (pInd-1 < 0) throw new IllegalStateException("* should be after some character");
                    boolean checkChar = s.charAt(sInd) == p.charAt(pInd-1) || p.charAt(pInd-1) == '.';
                    boolean c = checkChar && (dp[i-1][j] || dp[i][j-1]);
                    dp[i][j] = c || dp[i][j-2];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
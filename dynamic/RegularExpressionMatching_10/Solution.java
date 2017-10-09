package LeetCode.dynamic.RegularExpressionMatching_10;

/*
10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/description/

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
class Solution {
    // https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
    /**
     * Algorithm:
     * build matrix new boolean[s.len + 1][p.len + 1];
     * 1. fill dp[0][0] == true. Fill first column using next rule
     * true if current is * and prev-prev is true.
     * first row gives an answer does empty string corresponds the pattern. So we use * just like remove the char
     * first column is false excluding the [0][0] cell. Because not any not-empty string matches the "" pattern.
     *
     * 2. fill the matrix:
     * - if s[curr] == p[curr] || p[curr] == '.' => set dp[i][j] == dp[i-1][j-1];
     * which means we use the curr character in matching
     * - if p[curr] == '*', dp[i][j] should be set to a || b
     *  a. s[curr] == p[curr-1] || p[curr-1] == '.'
     *      => we can use value to the left dp[i][j-1] - use p[curr-1] once
     *      => we can use value to the top dp[i-1][j] - use p[curr-1] multiple times
     *      => we can use value to the top dp[i][j-1] - do not use p[curr-1]
     *  b. s[curr] != p[curr-1] && p[curr-1] != '.'
     *      => use dp[i][j-2] - means do not use p[curr-1]
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("ex");
        int m = s.length()+1, n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // fill first row
        for (int i=1; i<n; i++) {
            int pCurr = p.charAt(i-1);
            if (i-2 >= 0 && pCurr == '*') {
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
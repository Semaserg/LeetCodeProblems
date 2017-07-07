package LeetCode.dynamic.EditDistance_72;


/*
72. Edit Distance
https://leetcode.com/problems/edit-distance/#/description

Given two words word1 and word2, find the minimum number of steps required to convert
word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
// m == word1.length(), n == word2.length(),
// Time complexity O(mn), space complexity O(mn).
// https://web.stanford.edu/class/cs124/lec/med.pdf
// https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) throw new IllegalArgumentException("ex");
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int j=0; j<=n; j++) {
            dp[0][j] = j;
        }


        for (int i=1; i<=m; i++) { // rows
            for (int j=1; j<=n; j++) { // cols
                char w1Char = word1.charAt(i-1);
                char w2Char = word2.charAt(j-1);
                // go from top left to bottom right
                int dTop = dp[i-1][j] + 1;
                int dLeft = dp[i][j-1] + 1;
                // use +2 if substitute is 2 operations.
                int dLeftTop = (w1Char == w2Char) ? dp[i-1][j-1] : dp[i-1][j-1] + 1;
                dp[i][j] = Math.min(dLeftTop, Math.min(dTop, dLeft));
            }
        }

        return dp[m][n];
    }
}
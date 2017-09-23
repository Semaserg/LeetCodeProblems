package LeetCode.dynamic.LevenshteinDistance;

import java.util.Arrays;

/*
https://web.stanford.edu/class/cs124/lec/med.pdf
*/

public class Solution {

    public int findMinEditDistance(String a, String b) {
        if (a == null || b == null) throw new IllegalArgumentException("ex");
        int m = a.length(), n = b.length();
        int [][] dp = new int[m+1][n+1];
        String [][] pathTo = new String[m+1][n+1];
        for (int i=0; i<=m; i++) dp[i][0] = i;
        for (int j=0; j<=n; j++) dp[0][j] = j;

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                int replaceDist = dp[i-1][j-1] + ((a.charAt(i-1) == b.charAt(j-1)) ? 0 : 2);
                if (replaceDist < Math.min(dp[i-1][j]+1, dp[i][j-1]+1)) {
                    pathTo[i][j] = (i-1) +  "," + (j-1);
                    dp[i][j] = replaceDist;
                } else {
                    int del = dp[i-1][j]+1;
                    int ins = dp[i][j-1]+1;
                    if (del < ins) {
                        pathTo[i][j] = (i-1) +  "," + (j);
                        dp[i][j] = del;
                    } else {
                        pathTo[i][j] = (i) +  "," + (j-1);
                        dp[i][j] = ins;
                    }
                }
                // dp[i][j] = Math.min(replaceDist, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
            }
        }
        for (int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                System.out.print(pathTo[i][j] + " ");
            }
            System.out.println("");
        }
//        while(i != 0 && j!= 0) {
//            System.out.println(i + ", " + j);
//            String from = pathTo[i][j];
//            String[] parts = from.split(",");
//            i = Integer.valueOf(parts[0]);
//            j = Integer.valueOf(parts[1]);
//        }
        return dp[m][n];
    }
}
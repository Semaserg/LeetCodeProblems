package LeetCode.dynamic.UniquePaths_62;

/*
62. Unique Paths
https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.
*/
// Permutation approach
// https://discuss.leetcode.com/topic/19613/math-solution-o-1-space
// https://discuss.leetcode.com/topic/2734/my-ac-solution-using-formula/2
public class Solution {
    // Time complexity O(n), space complexity O(n).
    public int uniquePaths(int m, int n) {
        if (n==0 || m==0) return 0;
        if (m==1 || n==1) return 1;
        int [][] ways = new int[m][n];
        for (int i=0; i<m; i++) {
            ways[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            ways[0][j] = 1;
        }
        // as we updating ways line by line, we can use vector instead of matrix,
        // each iteration updating the same vector.
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++) {
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        return ways[m-1][n-1];
    }
    // vector approach example
    // https://discuss.leetcode.com/topic/15265/0ms-5-lines-dp-solution-in-c-with-explanations/2
//    class Solution {
//        int uniquePaths(int m, int n) {
//            if (m > n) return uniquePaths(n, m);
//            vector<int> cur(m, 1);
//            for (int j = 1; j < n; j++)
//                for (int i = 1; i < m; i++)
//                    cur[i] += cur[i - 1];
//            return cur[m - 1];
//        }
//    };
}
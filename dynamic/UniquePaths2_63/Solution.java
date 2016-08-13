package LeetCode.dynamic.UniquePaths2_63;

/*
63. Unique Paths II
https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.

Part 2:
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    // Time complexity O(n*m), space complexity O(n*m)
    // Great explanation
    // https://discuss.leetcode.com/topic/15267/4ms-o-n-dp-solution-in-c-with-explanations
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ways = new int[m][n];
        // fill top row
        for (int i=0; i<n; i++){
            if (obstacleGrid[0][i] != 1) {
                ways[0][i] = 1;
            }
            else {
                break; // rest of the array be 0, because of we can`t get there
            }
        }

        // fill first column
        for (int j=0; j<m; j++){
            if (obstacleGrid[j][0] != 1) {
                ways[j][0] = 1;
            }
            else {
                break; // rest of the array be 0, because of we can`t get there
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                } else {
                    ways[i][j] = ways[i-1][j] + ways[i][j-1];
                }
            }
        }
        return ways[m-1][n-1];
    }

    // Time complexity O(n*m), space complexity O(n)
    // https://discuss.leetcode.com/topic/10974/short-java-solution
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int[] ways = new int[n];
        ways[0] = 1;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[j] = 0;
                } else if (j>0) {
                    ways[j] += ways[j-1];
                }
            }
        }
        return ways[n-1];
    }

}
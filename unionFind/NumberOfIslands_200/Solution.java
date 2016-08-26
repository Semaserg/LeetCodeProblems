package LeetCode.unionFind.NumberOfIslands_200;

/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
*/
public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/13248/very-concise-java-ac-solution
    // Good union-find solution
    // https://discuss.leetcode.com/topic/33947/java-union-find-solution
    // Time complexity O(n).
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    destroyIsland(i, j, grid);
                }
            }
        }
        return count;
    }

    private void destroyIsland(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>m-1 || j>n-1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        destroyIsland(i-1, j, grid);
        destroyIsland(i+1, j, grid);
        destroyIsland(i, j-1, grid);
        destroyIsland(i, j+1, grid);
    }
}
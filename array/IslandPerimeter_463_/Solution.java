package LeetCode.array.IslandPerimeter_463_;

import java.util.HashSet;
import java.util.Set;

/**
 463. Island Perimeter
 https://leetcode.com/problems/island-perimeter/#/description

 You are given a map in form of a two-dimensional integer grid where 1
 represents land and 0 represents water. Grid cells are connected
 horizontally/vertically (not diagonally). The grid is completely
 surrounded by water, and there is exactly one island (i.e.,
 one or more connected land cells). The island doesn't have "lakes"
 (water inside that isn't connected to the water around the island).
 One cell is a square with side length 1. The grid is rectangular,
 width and height don't exceed 100. Determine the perimeter of the island.
 */
public class Solution {
    // https://discuss.leetcode.com/topic/68786/clear-and-easy-java-solution
    // islands * 4 - neighbours * 2
    public int islandPerimeter1(int[][] grid) {
        int sum = 0;
        int h = grid.length;
        int w = grid[0].length;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                sum += getEdges(i, j, grid);
            }
        }
        return sum;
    }

    // java.lang.StackOverflowError
    // same idea to track visited modified array, set -1 instead 1 when cell is visited
    // https://discuss.leetcode.com/topic/68751/easy-dfs-solution-explaination-without-visited-array
    private int getEdges(int row, int col, int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        if (grid[row][col] == 1) {
            int sum = 0;
            if (col-1 < 0 || grid[row][col-1] == 0) sum++;
            if (col+1 == w || grid[row][col+1] == 0) sum++;
            if (row-1 < 0 || grid[row-1][col] == 0) sum++;
            if (row+1 == h || grid[row+1][col] == 0) sum++;
            return sum;
        }
        return 0;
    }

    // dp solution
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        int h = grid.length;
        int w = grid[0].length;
        Set<String> visited = new HashSet<>();

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (grid[i][j] == 1) {
                    //visited.add(i+"-"+j);
                    return dp(i, j, grid, visited);
                }
            }
        }
        return sum;
    }

    private int dp(int row, int col, int[][] grid, Set<String> visited) {
        if (visited.contains("r:"+row+"c:"+col)) return 0;
        visited.add("r:"+row+"c:"+col);

        int sum = 0;
        int h = grid.length;
        int w = grid[0].length;
        if (col-1 < 0 || grid[row][col-1] == 0) sum++;
        else sum += dp(row, col-1, grid, visited);

        if (col+1 == w || grid[row][col+1] == 0) sum++;
        else sum += dp(row, col+1, grid, visited);

        if (row-1 < 0 || grid[row-1][col] == 0) sum++;
        else sum += dp(row-1, col, grid, visited);

        if (row+1 == h || grid[row+1][col] == 0) sum++;
        else sum += dp(row+1, col, grid, visited);

        return sum;
    }
}
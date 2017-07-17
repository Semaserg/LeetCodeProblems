package LeetCode.dynamic.BombEnemy_361;

/*
https://leetcode.com/problems/bomb-enemy/#/description
361. Bomb Enemy

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits
the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)*/
// https://discuss.leetcode.com/topic/48603/java-straightforward-solution-dp-o-mn-time-and-space
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Spot[][] spots = new Spot[m][n];
        // go top to bottom, left to right and calculate enemies can be destroyed up+curr and left+curr
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                spots[i][j] = new Spot();
                // leave counters 0 for wall cell.
                // Wall works like a stopper for cumulation of enemies - it's counters == 0,
                // so increasing of counters starts from 0
                if (grid[i][j] == 'W') continue;
                int currCellEnemy = (grid[i][j] == 'E') ? 1 : 0;
                spots[i][j].up = ((i > 0) ? spots[i-1][j].up : 0) + currCellEnemy;
                spots[i][j].left = ((j > 0) ? spots[i][j-1].left : 0) + currCellEnemy;
            }
        }

        int max = 0;
        // go bottom to up, right to left and calculate enemies can be destroyed to bottom and to right
        // calculate max number of enemies can be destroyed.
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                // Spot  instance is already created.
                if (grid[i][j] == 'W') continue; // leave counters 0 for wall cell.
                int currCellEnemy = (grid[i][j] == 'E') ? 1 : 0;
                spots[i][j].bottom = ((i < m-1) ? spots[i+1][j].bottom : 0) + currCellEnemy;
                spots[i][j].right = ((j < n-1) ? spots[i][j+1].right : 0) + currCellEnemy;

                if (grid[i][j] == '0') {
                    int localMax = spots[i][j].up + spots[i][j].left + spots[i][j].bottom + spots[i][j].right;
                    if (currCellEnemy == 1) {
                        localMax = localMax - 3; // current enemy cell was included 4 times in up, left, right, bottom.
                    }
                    max = Math.max(max, localMax);
                }
            }
        }
        return max;
    }
}
//class Spot {
//    public int up; // enemies that can be destroyed up + current cell enemy;
//    public int bottom; // enemies that can be destroyed to the bottom  + current cell enemy;
//    public int left; // enemies that can be destroyed to the left + current cell enemy;
//    public int right; // enemies that can be destroyed to the right  + current cell enemy;
//}
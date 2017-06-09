package LeetCode.dynamic.RangeSumQuery2DImmutable_304;

/*
https://leetcode.com/problems/range-sum-query-2d-immutable/#/description
304. Range Sum Query 2D - Immutable

Given a 2D matrix matrix, find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
 and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
// Great explanation
// https://discuss.leetcode.com/topic/29536/clean-c-solution-and-explaination-o-mn-space-with-o-1-time
public class NumMatrix {
    private int[][] cache;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m][n];

        // sum from left to right
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // first column with no changes
                if (j==0) {
                    cache[i][j] = matrix[i][j];
                } else {
                    cache[i][j] = cache[i][j-1] + matrix[i][j];
                }
            }
        }

        // sum from top to bottom
        // first row with no changes => start i from 1.
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                cache[i][j] += cache[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // top region sum
        int top = (row1 == 0) ? 0 : cache[row1-1][col2];

        // left region sum
        int left = (col1 == 0) ? 0 : cache[row2][col1-1];

        // intersection area of left and top
        int intersection = (row1 == 0 || col1 == 0) ? 0 : cache[row1-1][col1-1];

        // big region including all the area from {0,0} to {row2, col2}.
        int region = cache[row2][col2];

        return region - (top + left - intersection);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
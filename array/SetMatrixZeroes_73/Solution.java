package LeetCode.array.SetMatrixZeroes_73;

/**
 73. Set Matrix Zeroes
 https://leetcode.com/problems/set-matrix-zeroes/

 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Solution {
    // Good solution
    //https://discuss.leetcode.com/topic/5056/any-shortest-o-1-space-solution
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // matrix[0][0] - is common for row0 and col0, thus we could use matrix[0][0] for row0,
        // and col0 variable for col0;
        int col0 = 1;
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) col0 = 0; // make this check before updates in the loop below.
            for (int j=1; j<n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // first col update.
                    matrix[0][j] = 0;
                }
            }
        }
        // go from bottom to the top to save the data in the first row
        for (int i=m-1; i>=0; i--) {
            // this loop is no metter left-right, or right-left,
            // because we will update first column outside of the loop depending on col0.
            for (int j=n-1; j>=1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    // My stupid solution
    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean cleanFirstRow = false;
        boolean cleanFirstColumn = false;
        // travers the matrix and mark in the first row and first column what we should clean.
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == 0) {
                        cleanFirstColumn = true;
                        cleanFirstRow = true;
                    }
                }
                else if (i == 0) {
                    if (matrix[i][j] == 0) cleanFirstRow = true;
                }
                else if (j == 0) {
                    if (matrix[i][j] == 0) cleanFirstColumn = true;
                }
                else if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // clean rows by first column.
        // do not touch first row - we need it to clean the columns.
        for (int i=1; i<m; i++) {
            if (matrix[i][0] == 0) {
                for(int j=0; j<n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // clean columns by first row.
        for (int j=1; j<n; j++) {
            if (matrix[0][j] == 0) {
                for(int i=0; i<m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // clean first row if needed
        if (cleanFirstRow) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        // clean first column if needed
        if (cleanFirstColumn) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
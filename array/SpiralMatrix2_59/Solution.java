package LeetCode.array.SpiralMatrix2_59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 59. Spiral Matrix II
 https://leetcode.com/problems/spiral-matrix-ii/

 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        if (n == 1) return new int[][]{{1}};
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int k = 1;
        while (true) {
            for (int i=left; i<=right; i++) {
                matrix[top][i] = k;
                k++;
            }
            top++;
            if (k > n*n) break;

            for (int i=top; i<=bottom; i++) {
                matrix[i][right] = k;
                k++;
            }
            right--;

            for (int i=right; i>=left; i--) {
                matrix[bottom][i] = k;
                k++;
            }
            bottom--;
            if (k > n*n) break;

            for (int i=bottom; i>=top; i--) {
                matrix[i][left] = k;
                k++;
            }
            left++;
        }
        return matrix;
    }
}

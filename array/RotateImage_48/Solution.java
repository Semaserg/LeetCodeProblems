package LeetCode.array.RotateImage_48;

import java.util.Arrays;

/*
 48. Rotate Image
 https://leetcode.com/problems/rotate-image/#/description

 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Solution {
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;
        for (int i=0; i<matrix.length/2; i++) {
            rotateRow(matrix, i);
        }
    }

    private void rotateRow(int[][] matrix, int i) {
        int last = matrix.length-1;
        for(int j=0; j<matrix.length-2*i-1; j++) {
            int temp = matrix[i][i+j];
            matrix[i][i+j] = matrix[last-i-j][i];
            matrix[last-i-j][i] = matrix[last-i][last-i-j];
            matrix[last-i][last-i-j] = matrix[i+j][last-i];
            matrix[i+j][last-i] = temp;
        }
    }

    // Great solution
    // https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;
        reverse(matrix);
        for (int i=0; i<matrix.length; i++) {
            for (int j=i+1; j<matrix.length; j++) {
                swap(matrix, i, j);
            }
        }
    }

    private void reverse(int[][] matrix) {
        int[] temp;
        for(int i=0; i<matrix.length/2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
    }

    private void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
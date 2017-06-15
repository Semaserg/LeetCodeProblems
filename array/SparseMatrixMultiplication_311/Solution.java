package LeetCode.array.SparseMatrixMultiplication_311;

import java.util.ArrayList;
import java.util.List;

/**
 311. Sparse Matrix Multiplication
 https://leetcode.com/problems/sparse-matrix-multiplication/#/description

 Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A[0].length != B.length) return null;
        int h = A.length, w = B[0].length;
        int[][] result = new int[h][w];
        for (int i=0; i<h; i++) {
            List<Integer> indexes = getNotEmptyIndexes(A[i]);
            for (int j=0; j<w; j++) {
                result[i][j] = getSum(i, j, indexes, A, B);
            }
        }
        return result;
    }

    private List<Integer> getNotEmptyIndexes(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] != 0) list.add(i);
        }
        return list;
    }

    private int getSum(int row, int col, List<Integer> indexes, int[][] A, int[][] B) {
        int res = 0;
        for (int i: indexes) {
            res += A[row][i] * B[i][col];
        }
        return res;
    }
}
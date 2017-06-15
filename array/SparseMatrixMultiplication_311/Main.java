package LeetCode.array.SparseMatrixMultiplication_311;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] A = new int[][] {{1,2}, {3,4}};
        int[][] B = new int[][] {{1,2}, {3,4}};
        int[][] matrix = s.multiply(A,B);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}



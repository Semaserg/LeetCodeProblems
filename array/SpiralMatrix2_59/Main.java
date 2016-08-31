package LeetCode.array.SpiralMatrix2_59;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = s.generateMatrix(3);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}



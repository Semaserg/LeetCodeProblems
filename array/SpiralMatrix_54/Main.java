package LeetCode.array.SpiralMatrix_54;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] matrix = {{1,2,3}, {8,9,4}, {7,6,5}};
        int[][] matrix = {{1,3},{2,5},{3,7}};
        List<Integer> resuilt = s.spiralOrder(matrix);
        System.out.print(resuilt);
    }
}



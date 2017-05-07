package LeetCode.array.ReshapeTheMatrix_566_;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,2}, {3,4}};
        int[][] result = s.matrixReshape(a, 1, 4);
        for(int[] row : result) {
            System.out.print(Arrays.toString(row));
        }
    }
}



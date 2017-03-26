package LeetCode.array.DiagonalTraverse_498;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][] {
                {1,2,6},
                {3,5,7},
                {4,8,9}
        };
        int[] res = s.findDiagonalOrder(matrix);
        System.out.print(Arrays.toString(res));
    }
}



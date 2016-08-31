package LeetCode.array.RotateImage_48;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,2,3,4,0,0}, {5,6,7,8,1,1}, {9,10,11,12,2,2}, {13,14,15,16,3,3}, {7,2,5,4,7,5}, {7,3,6,4,5,6}};
        s.rotate(matrix);
        for (int i=0; i<matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            System.out.println("");
        }
    }
}



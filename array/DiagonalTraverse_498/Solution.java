package LeetCode.array.DiagonalTraverse_498;

import java.util.ArrayList;
import java.util.List;

/**
 498. Diagonal Traverse
 https://leetcode.com/problems/diagonal-traverse/#/description

 Given a matrix of M x N elements (M rows, N columns), return all elements
 of the matrix in diagonal order as shown in the below image.
 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]
 */
public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/77865/concise-java-solution
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};

        int h = matrix.length, w = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int col = 0, row = 0;
        boolean topToBottom = false;

        while (row<h && col<w) {
            int current = matrix[row][col];
            res.add(current);
            if (row == 0 && col < w-1 && !topToBottom) {col++; topToBottom = true;}
            else if (col == w-1 && row < h-1 && !topToBottom) {row++; topToBottom = true;}
            else if (col == 0 && row+1 < h && topToBottom) {row++; topToBottom = false;}
            else if (row == h-1 && col < w-1 && topToBottom) {col++; topToBottom = false;}
            else {
                if (topToBottom) { col--; row++; }
                else {col++; row--; }
            }
        }

        int[] arr = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

//    https://discuss.leetcode.com/topic/77865/concise-java-solution
//    public class Solution {
//        public int[] findDiagonalOrder(int[][] matrix) {
//            if (matrix == null || matrix.length == 0) return new int[0];
//            int m = matrix.length, n = matrix[0].length;
//
//            int[] result = new int[m * n];
//            int row = 0, col = 0, d = 0;
//            int[][] dirs = {{-1, 1}, {1, -1}};
//
//            for (int i = 0; i < m * n; i++) {
//                result[i] = matrix[row][col];
//                row += dirs[d][0];
//                col += dirs[d][1];
//
//                if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
//                if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
//                if (row < 0)  { row = 0; d = 1 - d;}
//                if (col < 0)  { col = 0; d = 1 - d;}
//            }
//
//            return result;
//        }
//    }
}
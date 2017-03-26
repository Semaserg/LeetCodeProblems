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
}
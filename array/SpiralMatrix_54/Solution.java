package LeetCode.array.SpiralMatrix_54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 54. Spiral Matrix
 https://leetcode.com/problems/spiral-matrix/

 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    // time complexity O(n), space complexity O(n).
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        int edge = Math.min(m, n);
        int iterations = (edge)/2 + edge%2;
        for(int i=0; i<iterations; i++) {
            res.addAll(sq(matrix, i));
        }
        return res;
    }

    private List<Integer> sq(int[][] matrix, int s) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int x,y;
        // go left->right in the top edge
        y=s;
        for (x=s; x<m-s; x++) res.add(matrix[y][x]);

        // go top->bottom in the right edge
        x=m-s-1;
        for (y=s+1; y<n-s; y++) res.add(matrix[y][x]);

        // go right->left in the bottom edge
        y=n-s-1;
        if (y>s) { // check that this is not the same line as left->right
            for (x=m-s-2; x>=s; x--) res.add(matrix[y][x]);
        }
        // go bottom->top in the left edge
        x=s;
        if (x<m-s-1) { // check this is not the same line as bottom->top
            for (y=n-s-2; y>s; y--) res.add(matrix[y][x]);
        }
        return res;
    }

    // Two great solutions
    // https://discuss.leetcode.com/topic/44784/clean-java-readable-human-friendly-code
    // https://discuss.leetcode.com/topic/3713/super-simple-and-easy-to-understand-solution
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        while (true) {
            for (int i=left; i<= right; i++) res.add(matrix[top][i]);
            top++;
            if (top>bottom || left>right) break;

            for (int i=top; i<=bottom; i++) res.add(matrix[i][right]);
            right--;
            if (top>bottom || left>right) break;

            for (int i=right; i>=left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (top>bottom || left>right) break;

            for (int i=bottom; i>=top; i--) res.add(matrix[i][left]);
            left++;
            if (top>bottom || left>right) break;
        }
        return res;
    }
}
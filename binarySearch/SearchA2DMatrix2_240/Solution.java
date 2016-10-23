package LeetCode.binarySearch.SearchA2DMatrix2_240;

/*
240. Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

public class Solution {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return recursiveSearch(matrix, target, 0, 0, m-1, n-1);
    }

    // Time complexity - O(???);
    // Space complexity - O(???);
    // Same idea
    // https://discuss.leetcode.com/topic/33240/java-an-easy-to-understand-divide-and-conquer-method
    private boolean recursiveSearch(int[][] matrix, int target, int y1, int x1, int y2, int x2) {
        if (x1 > x2 || y1 > y2) return false;
        if (target < matrix[y1][x1] || target > matrix[y2][x2])  return false;
        if (y1 == y2 && x1 == x2) return matrix[y1][x1] == target;

        int midY = y1 + (y2 - y1) / 2;
        int midX = x1 + (x2 - x1) / 2;

        // divide the matrix into four equal pieces and do the same recursively.
        return recursiveSearch(matrix, target, y1, x1, midY, midX) || // top left square
               recursiveSearch(matrix, target, y1, midX+1, midY, x2) || // top right
               recursiveSearch(matrix, target, midY+1, x1, y2, midX) || // bottom left
               recursiveSearch(matrix, target, midY+1, midX+1, y2, x2); // bottom right
    }


    // Great not recursive solution - binary search tree
    // https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution O(n+m) time complexity.
    // Same idea
    // https://discuss.leetcode.com/topic/45543/my-c-soluation-using-binary-search-tree-model-beats-100
    // we can treat the left bottom as a root of a BST so we only need o(m+N) to find the target
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row < m && col >= 0) {
            int curr = matrix[row][col];
            if (curr == target) return true;
            if (curr > target) col--;
            else row++; // if (cur<target) ...
        }
        return false;
    }
}

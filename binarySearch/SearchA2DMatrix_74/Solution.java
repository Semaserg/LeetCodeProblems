package LeetCode.binarySearch.SearchA2DMatrix_74;

/*
74. Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {

    // My stupid solution
    // Time complexity O(log n + log m), space complexity O(1).
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n= matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }

        int lo = 0;
        int hi = m-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
                return bs(matrix[mid], target);
            }
            if (target < matrix[mid][0]) hi = mid-1;
            else if (target > matrix[mid][n-1]) lo = mid+1;
        }
        return false;
    }

    private boolean bs(int[] array, int target) {
        int lo = 0;
        int hi = array.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (array[mid] == target) return true;
            if (target < array[mid]) hi = mid - 1;
            else if (target > array[mid]) lo = mid + 1;
        }
        return false;
    }
// Great solution, treating matrix as array, time complexity O(log(n+m)), is better than O(log n + log m)
// https://discuss.leetcode.com/topic/3227/don-t-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list
// https://discuss.leetcode.com/topic/51589/two-java-solutons-o-log-m-n-is-better-than-o-log-m-log-n - good description
//    class Solution {
//        public:
//        bool searchMatrix(vector<vector<int> > &matrix, int target) {
//            int n = matrix.size();
//            int m = matrix[0].size();
//            int l = 0, r = m * n - 1;
//            while (l != r){
//                int mid = (l + r - 1) >> 1;
//                if (matrix[mid / m][mid % m] < target)
//                    l = mid + 1;
//                else
//                    r = mid;
//            }
//            return matrix[r / m][r % m] == target;
//        }
//    };

//https://discuss.leetcode.com/topic/29159/java-clear-solution
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i = 0, j = matrix[0].length - 1;
//        while (i < matrix.length && j >= 0) {
//            if (matrix[i][j] == target) {
//                return true;
//            } else if (matrix[i][j] > target) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//
//        return false;
//    }
}
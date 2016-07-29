package LeetCode.array.Triangle_120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 120. Triangle
 https://leetcode.com/problems/triangle/

 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution {

    // FROM TOP TO BOTTOM. ABSOLUTELY WRONG SOLUTION.
    // Because of most of the triangle even not scanned, so some good path can be lost.
    // [[-1],[2,3],[1,-1,-3]] - this algorithm returns 0, (-1 -> 2 -> -1). But better path (-1 -> 3 -> -3)
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size()==1) return triangle.get(0).get(0);
        int root = 0;
        int path = triangle.get(0).get(0);
        for (int i=1; i<triangle.size(); i++) {
            int left = root;
            int right = root+1;
            List<Integer> row = triangle.get(i);
            if (row.get(left) < row.get(right)) {
                path +=row.get(left);
                root = left;
            } else {
                path += row.get(right);
                root = right;
            }
        }
        return path;
    }

    // from bottom to top.
    // https://discuss.leetcode.com/topic/1669/dp-solution-for-triangle - good explanation.
//    'Bottom-up' DP, on the other hand, is very straightforward: we start from the nodes on
//      the bottom row; the min pathsums for these nodes are the values of the nodes themselves.
//      From there, the min pathsum at the ith node on the kth row would be the lesser of the pathsums
//      of its two children plus the value of itself, i.e.:
//
//    minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
//    Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed,
//      we can simply set minpath as a 1D array, and iteratively update itself:
//
//    For the kth level:
//    minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==1) return triangle.get(0).get(0);

        // copy last row to the path array.
        List<Integer> rowPath = new ArrayList<>(triangle.size());
        rowPath.addAll(triangle.get(triangle.size()-1));

        // go from the "second from the bottom" row of triangle to the top.
        for (int i=triangle.size()-2; i>=0; i--) {
            // got fromm left to right and update the rowPath with the data for current row.
            List<Integer> currentRow = triangle.get(i);
            for(int j=0; j<currentRow.size(); j++) {
                int nextValue = Math.min(rowPath.get(j), rowPath.get(j+1)) + currentRow.get(j);
                rowPath.set(j, nextValue);
            }
            // it is not necessary.
            rowPath.remove(rowPath.size()-1);
        }
        return rowPath.get(0);
    }
}
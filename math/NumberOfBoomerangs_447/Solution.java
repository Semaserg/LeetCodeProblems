package LeetCode.math.NumberOfBoomerangs_447;

import java.util.HashMap;

/**
447. Number of Boomerangs
https://leetcode.com/problems/number-of-boomerangs/?tab=Description

Given n points in the plane that are all pairwise distinct, a "boomerang"
is a tuple of points (i, j, k) such that the distance between i and j equals
the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
Show Company Tags
Hide Tags
*/
// https://discuss.leetcode.com/topic/66587/clean-java-solution-o-n-2-166ms
//
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null) throw new IllegalArgumentException("points should not be null");
        if (points.length < 3) return 0;
        int counter = 0;

        for (int[] fp : points) {
            HashMap<Integer, Integer> dist = new HashMap<>(); // <distance, counter>
            for (int[] sp : points) {
                if (fp == sp) continue;
                // http://www.mathwarehouse.com/algebra/distance_formula/index.php
                // dist = sqrt( (x1 - x2)^2 + (y1 - y2)^2 )
                int squareDistance = (fp[0]-sp[0])*(fp[0]-sp[0]) + (fp[1]-sp[1])*(fp[1]-sp[1]);
                if (!dist.containsKey(squareDistance)) {
                    dist.put(squareDistance, 1);
                } else {
                    int nextDistCounter = dist.get(squareDistance) + 1;
                    dist.put(squareDistance, nextDistCounter);

                    // can be changed with iteration hashmap after the loop and adding cnt*(cnt-1) to global counter.
                    // counter += cnt*(cnt-1)
                    counter += 2 * (nextDistCounter - 1);
                }
            }
        }
        return counter;
    }
}
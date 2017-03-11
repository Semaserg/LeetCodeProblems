package LeetCode.math.MaxPointsOnALine_149;

/**
 149. Max Points on a Line
 https://leetcode.com/problems/max-points-on-a-line/?tab=Description

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/
// https://discuss.leetcode.com/topic/18447/16ms-28ms-c-solutions-with-explanations
// https://discuss.leetcode.com/topic/2979/a-java-solution-with-notes/2
// http://www.geeksforgeeks.org/count-maximum-points-on-same-line/

import java.util.HashMap;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        int maxPoints = 0;

        HashMap<Double, Integer> counterMap = new HashMap<>();
        for (int i=0; i<points.length-1; i++) {
            Point first = points[i];
            int localMax = 1;
            int overlap = 0;
            counterMap.clear();

            for (int j=i+1; j<points.length; j++) {
                Point second = points[j];//2,2

                int deltaX = first.x - second.x;
                int deltaY = first.y - second.y;

                if (deltaX == 0 && deltaY == 0) {
                    overlap++;
                    continue;
                }

                //double slope = (deltaY == 0) ? Integer.MAX_VALUE :  (double)deltaX / deltaY; -- error because of -0.0
                double slope = 0.0;
                if (deltaX == 0) slope = 0.0;
                else if (deltaY == 0) slope = (double)Integer.MAX_VALUE;
                else slope = (double)deltaX / (double)deltaY;

                int counter = 0;
                if (counterMap.containsKey(slope)) {
                    counter = counterMap.get(slope) + 1;
                } else {
                    counter = 2; // because of 2 points in a line
                }
                counterMap.put(slope, counter); // 1,1 -> 2
                localMax = Math.max(localMax, counter); // 2
            }
            localMax += overlap;
            maxPoints = Math.max(maxPoints, localMax);
        }
        return maxPoints;
    }
}
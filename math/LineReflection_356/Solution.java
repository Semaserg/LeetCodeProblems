package LeetCode.math.LineReflection_356;

import java.util.Arrays;
import java.util.HashSet;

/**
 356. Line Reflection
 https://leetcode.com/problems/line-reflection/?tab=Description

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
*/
// https://discuss.leetcode.com/topic/48172/simple-java-hashset-solution
// https://discuss.leetcode.com/topic/47851/11ms-two-pass-hashset-based-java-solution
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null) return false;
        if (points.length == 0 || points.length == 1) return true;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int[] point : points) {
            maxX = Math.max(maxX, point[0]);
            minX = Math.min(minX, point[0]);
            set.add(Arrays.hashCode(point));
        }
        if (maxX == minX) return true;
        int sum = minX + maxX;
        for (int[] point : points) {
            int reflectedPointX = sum - point[0];
            int [] reflecetedPoint = new int[] {reflectedPointX, point[1]};
            if (!set.contains(Arrays.hashCode(reflecetedPoint))) {
                return false;
            }
        }
        return true;
    }
}
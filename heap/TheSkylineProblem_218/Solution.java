package LeetCode.heap.TheSkylineProblem_218;

/*
218. The Skyline Problem
https://leetcode.com/problems/the-skyline-problem/description/

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a
distance. Now suppose you are given the locations and height of all the buildings as shown on
a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all
  buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as:
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
A key point is the left endpoint of a horizontal line segment. Note that the last key point,
 where the rightmost building ends, is merely used to mark the termination of the skyline,
 and always has zero height. Also, the ground in between any two adjacent buildings should
 be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:
[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline.
For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable;
the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
*/

import java.util.*;

class Solution {
    public List<int[]> getSkyline1(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;

        int size = buildings.length;
        int max = right(buildings[size-1]);
        int[] heightMap = new int[max];

        for(int[] b : buildings) {
            for(int i=left(b); i<=right(b); i++) {
                if (i == max) continue;
                heightMap[i] = Math.max(heightMap[i], height(b));
            }
        }

        if (heightMap[0] > 0) res.add(point(0, heightMap[0]));
        for(int i=1; i<max; i++) {
            if (heightMap[i-1] < heightMap[i]) res.add(point(i, heightMap[i]));
            else if (heightMap[i-1] > heightMap[i]) res.add(point(i-1, heightMap[i]));
        }
        res.add(point(max, 0));
        return res;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;

        List<Point> criticalPoints = new ArrayList<>();
        for (int[] b : buildings) {
            criticalPoints.add(new Point(b[0], b[2], true));
            criticalPoints.add(new Point(b[1], b[2], false));
        }

        Collections.sort(criticalPoints, (a, b) ->
                (a.getX() != b.getX()) ? a.getX() - b.getX() : a.getY() - b.getY());
        Queue<Integer> heights = new PriorityQueue<>((a,b) ->  b - a);
        heights.offer(0); // need to fill last point
        int prevHeight = 0;

        for (Point p: criticalPoints) {
            if (p.getIsStart()) {
                heights.offer(p.getY());
            } else {
                heights.remove(p.getY());
            }
            int currHeight = heights.peek();
            if (currHeight != prevHeight) {
                res.add(new int[] {p.getX(), currHeight});
                prevHeight = currHeight;
            }
        }
        return res;
    }

    private int left(int[] point) { return point[0]; }
    private int right(int[] point) { return point[1]; }
    private int height(int[] point) { return point[2]; }
    private int[] point(int x, int y) { return new int[]{x, y}; }
}

class Point {
    private final int x;
    private final int y;
    private final boolean isStart;
    Point(int x, int y, boolean isStart) {
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean getIsStart() { return isStart; }
}
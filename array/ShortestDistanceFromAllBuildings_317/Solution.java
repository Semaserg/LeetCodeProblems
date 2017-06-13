package LeetCode.array.ShortestDistanceFromAllBuildings_317;

import java.util.*;

/**
 317. Shortest Distance from All Buildings
 https://leetcode.com/problems/shortest-distance-from-all-buildings/#/description

 You want to build a house on an empty land which reaches all buildings in the
 shortest amount of distance. You can only move up, down, left and right.
 You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (1,2) is an ideal empty land to build a house, as the total travel
 distance of 3+3+1=7 is minimal. So return 7.

 Note:
 There will be at least one building. If it is not possible to build such house
 according to the above rules, return -1.
 */
// https://discuss.leetcode.com/topic/31925/java-solution-with-explanation-and-time-complexity-analysis
public class Solution {
    int[][] distances;
    int[][] reach;
    int totalBuildings;

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        distances = new int[m][n];
        reach = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                Point p = new Point(i, j, grid);
                if (p.isBuilding()) {
                    totalBuildings++;
                    bfs(p);
                }
            }
        }

        int minDistance = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == totalBuildings) {
                    if (minDistance == -1) minDistance = distances[i][j];
                    else minDistance = Math.min(minDistance, distances[i][j]);
                }
            }
        }
        return minDistance;
    }

    // http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
    private void bfs(Point p) {
        Set<Point> visited = new HashSet<>();
        visited.add(p);

        Queue<Point> q = new LinkedList<>();
        q.add(p);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Point curr = q.remove();
                if (curr.isFree()) {
                    distances[curr.i][curr.j] += distance;
                    reach[curr.i][curr.j] += 1;
                }

                List<Point> neighbors = curr.getFreeNeighbors();
                for(Point neighbor : neighbors) {
                    if (!visited.contains(neighbor))  {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            distance++;
        }
    }
}

class Point {
    public int i;
    public int j;
    public int m;
    public int n;
    public int[][] grid;

    public Point(int i, int j, int[][] grid) {
        this.i = i;
        this.j = j;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
    }

    public List<Point> getFreeNeighbors() {
        List<Point> list = new ArrayList<>();
        if (i > 0) {
            Point p = new Point(i-1, j, grid);
            if (p.isFree()) list.add(p);
        }
        if (j > 0) {
            Point p = new Point(i, j-1, grid);
            if (p.isFree()) list.add(p);
        }
        if (i < m-1) {
            Point p = new Point(i+1, j, grid);
            if (p.isFree()) list.add(p);
        }
        if (j < n-1) {
            Point p = new Point(i, j+1, grid);
            if (p.isFree()) list.add(p);
        }
        return list;
    }

    public boolean isFree() {
        return grid[i][j] == 0;
    }

    public boolean isObstacle() {
        return grid[i][j] == 2;
    }

    public boolean isBuilding() {
        return grid[i][j] == 1;
    }

    @Override
    public int hashCode() {
        return i*797 + j*9997;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return this.i == p.i && this.j == p.j;
    }
}
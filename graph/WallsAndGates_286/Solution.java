package LeetCode.graph.WallsAndGates_286;

import java.util.*;

/**
 286. Walls and Gates
 https://leetcode.com/problems/walls-and-gates/#/description

 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent
 INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible
 to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
*/

public class Solution {
    //https://discuss.leetcode.com/topic/25265/java-bfs-solution-o-mn-time
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        int rows = rooms.length;
        int cols = rooms[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j}); //  add all gates to the queue
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0], col = curr[1];
            int dist = rooms[row][col];

            if (inPlane(row-1, col, rooms) && rooms[row-1][col] == Integer.MAX_VALUE){
                // rooms with Integer.MAX_VALUE are unvisited
                rooms[row-1][col] = dist+1; // mark as visited, set distance
                q.add(new int[]{row-1,col});
            }
            if (inPlane(row, col-1, rooms) && rooms[row][col-1] == Integer.MAX_VALUE){
                rooms[row][col-1] = dist+1;
                q.add(new int[]{row,col-1});
            }
            if (inPlane(row+1, col, rooms) && rooms[row+1][col] == Integer.MAX_VALUE){
                rooms[row+1][col] = dist+1;
                q.add(new int[]{row+1,col});
            }
            if (inPlane(row, col+1, rooms) && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = dist+1;
                q.add(new int[]{row,col+1});
            }
        }
    }

    private boolean inPlane(int row, int col, int[][] rooms) {
        return row>=0 && row<rooms.length && col>=0 && col<rooms[0].length;
    }
}

// my stupid solution
/*
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(i, j, rooms);
                }
            }
        }
    }

    private void bfs(int row, int col, int[][] rooms) {
        Point curr = new Point(row, col);
        Queue<Point> q = new LinkedList<>();
        q.add(curr);

        Set<Point> visited = new HashSet<>();
        visited.add(curr);

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Point p = q.remove();
                if (isRoom(p.row, p.col, rooms)) {
                    rooms[p.row][p.col] = Math.min(dist, rooms[p.row][p.col]);
                }
                List<Point> roomsAround = getNeighborRooms(p, rooms);
                for (Point room : roomsAround) {
                    if (!visited.contains(room)) {
                        visited.add(room);
                        q.add(room);
                    }
                }
            }
            dist++;
        }
    }

    private List<Point> getNeighborRooms(Point point, int[][] rooms) {
        List<Point> list = new ArrayList<>();
        // Up
        if (point.row > 0 && isRoom(point.row-1, point.col, rooms)) {
            list.add(new Point(point.row-1, point.col));
        }
        //Left
        if (point.col > 0 && isRoom(point.row, point.col-1, rooms)) {
            list.add(new Point(point.row, point.col-1));
        }
        //Down
        if (point.row < rooms.length-1 && isRoom(point.row+1, point.col, rooms)) {
            list.add(new Point(point.row+1, point.col));
        }
        //Right
        if (point.col < rooms[0].length-1 && isRoom(point.row, point.col+1, rooms)) {
            list.add(new Point(point.row, point.col+1));
        }
        return list;
    }

    private boolean isRoom(int row, int col, int[][] rooms) {
        return rooms[row][col] != 0 && rooms[row][col] != -1;
    }
}

class  Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);
        //return this.row*997 + this.col*9997;
    }
}*/
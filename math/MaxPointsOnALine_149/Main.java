package LeetCode.math.MaxPointsOnALine_149;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(4,0), new Point(4,-1), new Point(4,5)};
        Solution s = new Solution();
        int res = s.maxPoints(points);
        System.out.println(res);
        PriorityQueue<Tuple> pq = new PriorityQueue<>(10, (a,b)-> a.second-b.second);
    }
}
package LeetCode.design.MovingAverageFromDataStream_346;

import java.util.LinkedList;
import java.util.Queue;

/**
 346. Moving Average from Data Stream
 https://leetcode.com/problems/moving-average-from-data-stream/

 Given a stream of integers and a window size, calculate the moving
 average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3

 */
public class MovingAverage {
    private Queue<Integer> queue = new LinkedList<>();
    private int sum = 0;
    private int size = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.add(val);

        return (double)sum/(double)queue.size();
    }
}

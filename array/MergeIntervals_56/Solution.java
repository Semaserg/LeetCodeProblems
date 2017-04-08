package LeetCode.array.MergeIntervals_56;

import java.util.*;

/**
 56. Merge Intervals
 https://leetcode.com/problems/merge-intervals/#/description

 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class Solution {
    private boolean isOverlap(Interval first, Interval second) {
        return (first.start <= second.start && second.start <= first.end) ||
                (first.start <= second.end && second.end <= first.end);
    }

    private Interval merge(Interval first, Interval second) {
        return new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) throw new IllegalArgumentException("ex");
        if (intervals.size() < 2)  return intervals;

        //Collections.sort(intervals, (a,b)-> a.start-b.start);
        intervals.sort((a,b) -> a.start-b.start);
        List<Interval> result = new LinkedList<>();
        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (isOverlap(prev, next)) {
                prev = merge(prev, next);
            } else {
                result.add(prev);
                prev = next;
            }
        }
        result.add(prev);
        return result;
    }
}
package LeetCode.array.MergeIntervals_56;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return String.format("{%1$d, %2$d}", start, end);
    }
}
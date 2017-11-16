package LeetCode.array.RangeModule_715;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RangeModule {
    private final List<int[]> intervals = new ArrayList<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        int[] curr = new int[] {left, right};
        intervals.add(curr);
        checkIntervals();
    }

    private void checkIntervals() {
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int ind = 0;
        while(ind<intervals.size()-1) {
            int[] prev = intervals.get(ind);
            int[] next = intervals.get(ind+1);
            if (isIntersect(prev, next)) {
                int[] merged = merge(prev, next);
                next[0] = merged[0];
                next[1] = merged[1];
                intervals.remove(ind);
            } else ind++;
        }
    }

    private boolean isIntersect(int[] a, int[] b) {
        return (a[0] >= b[0] && a[0] <= b[1]) || (a[1] >= b[0] && a[1] <= b[1]) ||
                (b[0] >= a[0] && b[0] <= a[1]) || (b[1] >= a[0] && b[1] <= a[1]);
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public boolean queryRange(int left, int right) {
        int[] curr = new int[] {left, right};
        for(int[] i: intervals) {
            if (isIntersect(curr, i) && (i[0]<=left && i[1]>=right)) return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        int[] sb = new int[]{left, right};
        int ind = 0;
        while(ind<intervals.size()) {
            int[] curr = intervals.get(ind);
            if (curr[0] >= sb[1] || curr[1]<=sb[0] || !isIntersect(curr, sb)) {
                ind++;
            } else {
                intervals.remove(ind);
                intervals.addAll(subtract(curr, sb));
                ind++;
            }
        }
        checkIntervals();
    }

    private List<int[]> subtract(int[] a, int[] b) { // a - b (subrtact b from a)
        List<int[]> res = new ArrayList<>();
        if (a[0]>=b[0] && a[1]<=b[0]) return res; // remove interval, a inside b
        if (b[0]>a[0] && b[1]<a[1]) {
            res.add(new int[] {a[0], b[0]});
            res.add(new int[] {b[1], a[1]});
            return res;
        }
        if (a[0]>=b[0] && a[0] <= b[1]) {
            res.add(new int[] {b[0], a[1]});
            return res;
        }
        if (a[1]>=b[0] && a[1] <= b[1]) {
            res.add(new int[] {a[0], b[0]});
            return res;
        }
        throw new IllegalStateException("ex");
    }

}
//
//class Interval {
//    public final int left;
//    public final int right;
//    Interval(int left, int right) {
//        this.left = left;
//        this.right = right;
//    }
//}

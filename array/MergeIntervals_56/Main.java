package LeetCode.array.MergeIntervals_56;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        List<Interval> res = s.merge(list);
        for(Interval i : res) {
            System.out.println(i);
        }
    }
}



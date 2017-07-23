package LeetCode.array.MaxNonNegativeSubArray;

import LeetCode.array.MergeIntervals_56.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        ArrayList<Integer> res = s.maxset(list);
        System.out.println(res);
    }
}



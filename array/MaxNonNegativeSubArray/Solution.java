package LeetCode.array.MaxNonNegativeSubArray;

import LeetCode.array.MergeIntervals_56.Interval;

import java.util.*;

/**

 */
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = 0;
        ArrayList<Integer> res = new  ArrayList<>();
        if (a == null || a.size() == 0) return res;

        long sum = 0;
        ArrayList<Integer> current = new  ArrayList<>();
        for(int k=0; k<a.size(); k++) {
            int i = a.get(k);
            if (i < 0) {
                if (sum > maxSum || (sum == maxSum && current.size() > res.size())) {
                    res = new ArrayList<>(current);
                    maxSum = sum;
                }
                sum = 0;
                current = new ArrayList<>();
            } else {
                sum += i;
                current.add(i);
            }
        }
        if (sum > maxSum || (sum == maxSum && current.size() > res.size())) {
            res = new ArrayList<>(current);
            maxSum = sum;
        }
        return res;
    }
}
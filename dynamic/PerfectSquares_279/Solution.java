package LeetCode.dynamic.PerfectSquares_279;

import java.util.Arrays;

/*
279. Perfect Squares
https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect
square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
return 2 because 13 = 4 + 9.
*/
public class Solution {

    // My solution, looks like it works but - time limit exceeded.
    // Not sure:  time complexity O(branches^depth) => O(sqrt(n)^sqrt(n))
    // space complexity O(sqrt(n)) - because of stack.
    public int numSquares1(int n) {
        return ns(n, 0);
    }

    private int ns(int n, int sum) {
        if (n == 0) return sum;
        int sq = (int) Math.sqrt(n);
        int min = ns(n - sq * sq, sum + 1);
        if (min == sum + 1) return min;
        for (int i = 1; i < sq; i++) {
            min = Math.min(ns(n - i * i, sum + 1), min);
        }
        return min;
    }

    // Dynamic approach
    // https://discuss.leetcode.com/topic/24255/summary-of-4-different-solutions-bfs-dp-static-dp-and-mathematics
    public int numSquares(int n) {
        if (n <= 0) return 0;
        // contains number of perfect squares for each number from 0 to n.
        int[] perfSquareCounters = new int[n+1];
        perfSquareCounters[0] = 0;

        for (int i=1; i<=n; i++) {
            // calc first possible counter = counter of prev number + 1, because 1=1*1
            perfSquareCounters[i] = perfSquareCounters[i-1] + 1;
            for (int j=2; j*j<=i; j++) {
                // perfSquareCounters[i-j*j] - counter for i-j*j number.
                perfSquareCounters[i] = Math.min(perfSquareCounters[i], perfSquareCounters[i-j*j] + 1);
            }
        }
        return perfSquareCounters[n];
    }
}
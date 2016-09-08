package LeetCode.math.ValidPerfectSquare_367;

/*
367. Valid Perfect Square
https://leetcode.com/problems/valid-perfect-square/

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/
public class Solution {
    // binary search approach - version 1
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int lo = 0;
        int hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0) return false;
            int temp = num/mid;
            int remainder = num%mid;
            if (temp == mid && remainder == 0) return true;
            if (temp > mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    // binary search approach - version 2, use long instead of int
    public boolean isPerfectSquare1(int num) {
        long lo = 0;
        long hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long square = mid*mid;
            if (square == num) return true;
            if (square > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    // Newton`s root formula
    // https://discuss.leetcode.com/topic/49342/3-4-short-lines-integer-newton-most-languages
    public boolean isPerfectSquare2(int num) {
        long r = num;
        while (r*r > num) {
            r = (r + num/r)/2;
        }
        return r*r == num;
    }
}
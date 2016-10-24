package LeetCode.math.IntegerBreak_343;

/*
343. Integer Break
https://leetcode.com/problems/integer-break/

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

*/
// Time & space complexity O(1);
// https://discuss.leetcode.com/topic/42978/java-dp-solution - dp solution
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int rem = n%3;
        if (rem == 2) return (int)Math.pow(3, n/3) * 2;
        if (rem == 1) return (int)Math.pow(3, (n-4)/3) * 4;
        return (int)Math.pow(3, n/3); //if (n%3 == 0) return (int)Math.pow(3, n/3);
    }
}
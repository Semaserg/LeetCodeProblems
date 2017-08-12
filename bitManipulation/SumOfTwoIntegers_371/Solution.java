package LeetCode.bitManipulation.SumOfTwoIntegers_371;

/*
371. Sum of Two Integers
https://leetcode.com/problems/sum-of-two-integers/description/

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class Solution {
    public int getSum1(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int remainder = 0;
        int res = 0;
        while (remainder != 0 || a != 0 || b != 0) {
            int la = a & 1, lb = b & 1;
            a >>= 1;
            b >>= 1;
            res <<= 1;
            res |= la ^ lb ^ remainder;
            remainder = (la & lb) | (la & remainder) | (lb & remainder);
        }
        return res;
    }

    // https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;


        while (b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
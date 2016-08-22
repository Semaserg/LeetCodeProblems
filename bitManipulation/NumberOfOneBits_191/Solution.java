package LeetCode.bitManipulation.NumberOfOneBits_191;

/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/

Write a function that takes an unsigned integer and returns
 the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation
 00000000000000000000000000001011, so the function should return 3.
*/
// Good descroption
// https://discuss.leetcode.com/topic/11385/simple-java-solution-bit-shifting
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i=0; i<32; i++) {
            if ((n & 1) == 1) result++;
            n >>>=1;
        }
        return result;
    }
}
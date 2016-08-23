package LeetCode.bitManipulation.ReverseBits_190;

/*
190. Reverse Bits
https://leetcode.com/problems/reverse-bits/

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/
// Good explanation
// https://discuss.leetcode.com/topic/42572/sharing-my-2ms-java-solution-with-explanation
// https://discuss.leetcode.com/topic/9764/java-solution-and-optimization
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        // can`t use while(n!=0) here because we should shift result 32 times in any case.
        for(int i=0; i<32; i++) {
            result += n & 1; // n & 000....0001 => get last bit
            n >>>= 1;
            System.out.println(n);
            if (i<31) result <<= 1; // do not shift last digit
        }
        return result;
    }
}
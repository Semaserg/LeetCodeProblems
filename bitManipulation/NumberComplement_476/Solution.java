package LeetCode.bitManipulation.NumberComplement_476;

/*
476. Number Complement
https://leetcode.com/problems/number-complement/#/description

Given a positive integer, output its complement number. The complement strategy
is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits),
and its complement is 010. So you need to output 2.

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1
(no leading zero bits), and its complement is 0. So you need to output 0.
*/
public class Solution {
    //https://discuss.leetcode.com/topic/74642/java-1-line-bit-manipulation-solution
    //https://discuss.leetcode.com/topic/74838/java-one-line-solution-without-using-and-or-xor
//    To find complement of num = 5 which is 101 in binary.
//    First ~num gives ...11111010 but we only care about the rightmost 3 bits.
//    Then to erase the 1s before 010 we can add 1000
    public int findComplement(int num) {
        // 5 -> 0101 => Integer.highestOneBit(num) == 0100;
        // mask:   highestOneBit << 1   =>   0100 << 1   =>   1000
        // mask "-1":    1000 - 1  == 0111
        int mask = (Integer.highestOneBit(num) << 1) - 1;

        // ~num   =>   5 is 0101  =>   ~5 is 1010, but we need only last 3 bits
        // ~num & mask    =>    1010 & 0111 == 0010    =>   res = 2
        int res = ~num & mask;
        return res;
    }
}
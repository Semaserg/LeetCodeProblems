package LeetCode.bitManipulation.SingleNumber2_137;

/*
137. Single Number II
https://leetcode.com/problems/single-number-ii/description/

Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int[] counters = new int[32];
        for (int i=0; i<32; i++) {
            for (int num : nums) {
                counters[i]  += num>>i & 1;
            }
        }
        int result = 0;
        for(int i=31; i>=0; i--) {
            result <<= 1;
            result |= (counters[i]%3);
        }
        return result;
    }
}
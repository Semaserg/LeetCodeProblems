package LeetCode.bitManipulation.SingleNumber_136;

/*
136. Single Number
https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.
*/
public class Solution {
    //  A XOR A = 0 and the XOR operator is commutative.
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int i : nums) {
            temp ^= i;
        }
        return temp;
    }
}
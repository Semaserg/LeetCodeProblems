package LeetCode.bitManipulation.SingleNumber3_260;

/*
260. Single Number III
https://leetcode.com/problems/single-number-iii/

Given an array of numbers nums, in which exactly two elements appear only once and
all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only
 constant space complexity?
*/
public class Solution {
    // Explanation
    // https://discuss.leetcode.com/topic/25382/sharing-explanation-of-the-solution
    // https://discuss.leetcode.com/topic/34545/share-my-c-solution
    // https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
    public int[] singleNumber(int[] nums) {
        int xorOfTwoTargetNums = 0;
        for(int i : nums) {
            xorOfTwoTargetNums ^= i;
        }
        int[] result = new int[] {xorOfTwoTargetNums, xorOfTwoTargetNums};
        // for instance:
        // xorOfTwoTargetNums == 0111000  =>
        // xorOfTwoTargetNums-1 == 0110111
        // from left to right: before first 1 is the same (prefix), 0 instead of 1 (target bit) , 1s instead of 0s at the end (suffix);
        // ~(xorOfTwoTargetNums - 1 = 1001000 - inverted prefix (with & gives 0s), target == 1 in both, suffix = 0s.
        // xorOfTwoTargetNums & (~(xorOfTwoTargetNums - 1)) == 0001000 =>
        // it always has only one 1 in position where xorOfTwoTargetNums has last 1 (from rig to left).
        int lastBit = xorOfTwoTargetNums & (~(xorOfTwoTargetNums - 1));

        for (int j : nums) {
            // Group A - where j has 0 in the lastBit`s position
            if ((j & lastBit) == 0) {
                result[0] ^= j;
            }
            // Group B - where j has != 0 in the lastBit`s position
            else {
                result[1] ^= j;
            }
        }
        return result;
    }
}
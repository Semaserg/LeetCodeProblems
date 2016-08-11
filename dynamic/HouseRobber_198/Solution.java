package LeetCode.dynamic.HouseRobber_198;

import java.util.HashMap;

/*
198. House Robber
https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you
 from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken
 into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
*/
// Time complexity ???, space complexity ???.
public class Solution {
    // Time limit exceeded
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        return robRecursive1(0, nums);
    }

    private int robRecursive1(int index, int[] nums) {
        int lastIndex = nums.length-1;
        if (index>lastIndex) return 0;
        int a = nums[index] + robRecursive1(index+2, nums);
        int b = 0;
        int nextIndex = index + 1;
        if (nextIndex <= lastIndex) {
            b = nums[nextIndex] + robRecursive1(nextIndex+2, nums);
        }
        return Math.max(a,b);
    }

    // Time limit exceeded
    // Looks like time complexity O(2^n), n==nums.length;
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return robRecursive(0, nums);
    }

    /*
        M(k) = money at the kth house
        P(0) = 0
        P(1) = M(1)
        P(k) = max(P(k−2) + M(k), P(k−1))  */
    private int robRecursive(int index, int[] nums) {
        int lastIndex = nums.length-1;
        if (index>lastIndex) return 0;
        if (index==lastIndex) return nums[index];
        return Math.max(nums[index]+robRecursive(index+2,nums), robRecursive(index+1,nums));
    }

    // Good solutions, not recursive.
    // https://discuss.leetcode.com/topic/12024/java-dp-solution-o-n-runtime-and-o-1-space-with-inline-comment
    // https://discuss.leetcode.com/topic/11110/c-1ms-o-1-space-very-simple-solution
}
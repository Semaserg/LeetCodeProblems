package LeetCode.dynamic.HouseRobber_198;


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
        return robRecursive(0, nums);
    }

    /*
    M(k) = money at the kth house
    P(0) = 0
    P(1) = M(1)
    P(k) = max(P(k−2) + M(k), P(k−1))  */
    private int robRecursive(int index, int[] nums) {
        if (index>=nums.length) return 0;
        return Math.max(nums[index] + robRecursive(index+2, nums), robRecursive(index+1, nums));
    }

    // https://discuss.leetcode.com/topic/11110/c-1ms-o-1-space-very-simple-solution
    // https://discuss.leetcode.com/topic/12024/java-dp-solution-o-n-runtime-and-o-1-space-with-inline-comment
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0;
        int b = 0;
        for (int i=0; i<nums.length; i++) {
            if (i%2 ==0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(b + nums[i], a);
            }
        }
        return Math.max(a, b);
    }


    // Good solutions, not recursive.
    // https://discuss.leetcode.com/topic/12024/java-dp-solution-o-n-runtime-and-o-1-space-with-inline-comment
    // https://discuss.leetcode.com/topic/11110/c-1ms-o-1-space-very-simple-solution
}
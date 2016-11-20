package LeetCode.dynamic.MaximumSubarray_53;

/*
53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution
using the divide and conquer approach, which is more subtle.
*/
public class Solution {
    // Time complexity O(n), space - O(n)
    /*
    My thoughts about this: this is usual DP problem.
    1. You should build the next iteration using the data from the previous iteration.
    2. Think about input array as infinity-length array. In any item in array you should be able to define the result.
    Th idea is next. in every step you should make a decision: use previous subsequence + current element,
    or just current element.
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i=1; i<len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }

        int max = dp[0];
        for (int i=0; i<len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // refactored
    // Space complexity O(1)
    // https://discuss.leetcode.com/topic/5000/accepted-o-n-solution-in-java
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
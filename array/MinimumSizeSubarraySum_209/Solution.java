package LeetCode.array.MinimumSizeSubarraySum_209;

import java.util.Arrays;

/**
 209. Minimum Size Subarray Sum
 https://leetcode.com/problems/minimum-size-subarray-sum/

 Given an array of n positive integers and a positive integer s, find the minimal length
 of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
// https://discuss.leetcode.com/topic/18583/accepted-clean-java-o-n-solution-two-pointers
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len=-1, res=0, i=0, j=0, temp=0;
        while (i<nums.length) {
            res +=nums[i];
            temp++;
            if (res>=s) {
                while (res>=s) {
                    res-=nums[j];
                    j++;
                    temp--;
                }
                if (temp+1 < len || len<0) len = temp+1;
            }
            i++;
        }
        return (len==-1) ? 0 : len;
    }
}
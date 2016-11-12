package LeetCode.dynamic.LongestIncreasingSubsequence_300;

import java.util.Arrays;

/*
300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
Note that there may be more than one LIS combination, it is only necessary for
you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

// Great explanation of this problem
// https://habrahabr.ru/post/113108/
public class Solution {
    // Space complexity O(n)
    // Time complexity O(n^2 + n*log n) => O(n^2)
    // PLEASE TAKE A LOOK TO O(n log n) SOLUTION BASED ON BINARY SEARCH.
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] lis = new int[nums.length]; // contains max lis for each position in nums
        lis[0] = 1;
        // for + for - O(n^2)
        for (int i=1; i<nums.length; i++) {
            int max = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(lis[j]+1, max);
                }
            }
            lis[i] = max;
        }
        Arrays.sort(lis); // O(n*log n)
        return lis[lis.length-1];
    }
}
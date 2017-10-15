package LeetCode.array.DegreeOfAnArray_697;

import java.util.*;

/**
 697. Degree of an Array
 https://leetcode.com/contest/leetcode-weekly-contest-54/problems/degree-of-an-array/

 Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int degree = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i)+1);
            degree = Math.max(degree, map.get(i));
        }
        int res = Integer.MAX_VALUE;
        for (Integer i : map.keySet()) {
            if (map.get(i) == degree) {
                int minLen = minSubarrContainingX(nums, i);
                res = Math.min(res, minLen);
            }
        }
        return res;
    }

    private int minSubarrContainingX(int[] nums, int x) {
        int l=0, r = nums.length-1;
        while (l<r) {
            int li = nums[l], ri = nums[r];
            if (li == x && ri == x) return r-l+1;
            if (li != x) l++;
            if (ri != x) r--;
        }
        return r-l+1;
    }
}
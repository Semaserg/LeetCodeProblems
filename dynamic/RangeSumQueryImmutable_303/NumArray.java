package LeetCode.dynamic.RangeSumQueryImmutable_303;

/*
303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
// My stupid solution
//public class NumArray {
//
//    private int[] _nums;
//    public NumArray(int[] nums) {
//        _nums = nums;
//    }
//
//    // Time complexity O(n) in worst case
//    public int sumRange(int i, int j) {
//        if (_nums == null || _nums.length == 0 || i>j || j>=_nums.length || i>=_nums.length) {
//            return 0;
//        }
//        int res = 0;
//        for (int k=i; k<=j; k++){
//            res += _nums[k];
//        }
//        return res;
//    }
//}

import java.util.HashMap;
import java.util.Map;

// https://discuss.leetcode.com/topic/29194/java-simple-o-n-init-and-o-1-query-solution
public class NumArray {
    private int[] nums;

    // Time complexity O(n), space complexity O(n)
    public NumArray(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    // Time complexity O(1)
    public int sumRange(int i, int j) {
        if (nums.length == 0 || i>j || j>=nums.length || i>=nums.length) {
            return 0;
        }
        if (i==0) return nums[j];
        return nums[j]-nums[i-1];
    }
}

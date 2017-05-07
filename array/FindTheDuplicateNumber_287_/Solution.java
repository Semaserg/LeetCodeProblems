package LeetCode.array.FindTheDuplicateNumber_287_;

/**
 287. Find the Duplicate Number
 https://leetcode.com/problems/find-the-duplicate-number/#/description

 Given an array nums containing n + 1 integers where each integer is between
 1 and n (inclusive), prove that at least one duplicate number must exist.
 Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
// https://discuss.leetcode.com/topic/29101/simple-c-code-with-o-1-space-and-o-nlogn-time-complexity
//https://discuss.leetcode.com/topic/25580/two-solutions-with-explanation-o-nlog-n-and-o-n-time-o-1-space-without-changing-the-input-array
public class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            for (int i : nums) {
                if (i<=mid) cnt++; // calc how many items in [lo, mid] interval
            }
            if (cnt > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
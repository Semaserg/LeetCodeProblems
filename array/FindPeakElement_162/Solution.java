package LeetCode.array.FindPeakElement_162;

/**
 162. Find Peak Element
 https://leetcode.com/problems/find-peak-element/

 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class Solution {

    // O(n) time complexity
    public int findPeakElement1(int[] nums) {
        int len = nums.length;
        if (len<2) return 0;
        for (int i=0; i<len; i++) {
            int prev = (i==0) ? nums[len-1] : nums[i-1];
            int next = (i==len-1) ? nums[0] : nums[i+1];
            int curr = nums[i];
            if (curr>next && curr>prev) return i;
        }
        return 0;
    }

    // binary search, O(log n) time complexity
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len<2) return 0; // cover 0 and 1 elements in array.
        int left = 0;
        int right = len-1;
        // cover first and last elements in array, cover case when array has only 2 elements.
        if (nums[left]>nums[left+1]) return nums[left]; // because of left==0 and nums[-1] == -∞.
        if (nums[right]>nums[right-1]) return nums[right]; // because of right == len-1 and nums[len] == -∞.

        while (left<right) {
            int mid = (left + right)/2;
            if (nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) {
                return mid;
            }
            if (nums[mid]<nums[mid+1]) left=mid+1;
            else right=mid+1;
        }
        return 0;
    }
}

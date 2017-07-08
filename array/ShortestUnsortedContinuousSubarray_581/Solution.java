package LeetCode.array.ShortestUnsortedContinuousSubarray_581;

/**
 581. Shortest Unsorted Continuous Subarray
 https://leetcode.com/problems/shortest-unsorted-continuous-subarray/#/description

 Given an integer array, you need to find one continuous subarray that
 if you only sort this subarray in ascending order, then the whole
 array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 */
// https://discuss.leetcode.com/topic/89300/java-solution-sort
// https://discuss.leetcode.com/topic/89282/java-o-n-time-o-1-space
// https://discuss.leetcode.com/topic/93391/ideas-behind-the-o-n-two-pass-and-one-pass-solutions
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("ex");
        if (nums.length < 2) return 0;

        int l = 0, r = nums.length-1;

        while (l<r && nums[l]<= nums[l+1]) l++;
        if (l >= r) return 0;

        while (nums[r] >= nums[r-1]) r--;

        int min = nums[l], max = nums[r];
        for(int i=l; i<=r; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while (l>=0 && nums[l]>min) l--;

        while (r<nums.length && nums[r]<max) r++;

        return r - l - 1;
    }
}
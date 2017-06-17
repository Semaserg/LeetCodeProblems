package LeetCode.array.WiggleSort_280;

/**
 280. Wiggle Sort
 https://leetcode.com/problems/wiggle-sort/#/description

 Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length<2) return;
        for (int i=1; i<nums.length; i++) {
            int prev = nums[i-1], curr = nums[i];
            if (isOdd(i) && prev > curr) swap(nums, i);
            else if (!isOdd(i) && prev < curr) swap(nums, i);
        }
    }

    private boolean isOdd(int i) {
        return i%2 == 1;
    }

    private void swap(int[] nums, int i) {
        int temp = nums[i-1];
        nums[i-1] = nums[i];
        nums[i] = temp;
    }
}
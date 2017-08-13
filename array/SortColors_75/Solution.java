package LeetCode.array.SortColors_75;

import java.util.ArrayList;
import java.util.List;

/**
 75. Sort Colors
 https://leetcode.com/problems/sort-colors/description/

 Given an array with n objects colored red, white or blue, sort them so that
 objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class Solution {
    //http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int lo = 0, hi = nums.length-1, mid = 0;
        while (mid <= hi) {
            switch (nums[mid]) {
                case 0:
                    swap(lo, mid, nums);
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid, hi, nums);
                    hi--;
                    break;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
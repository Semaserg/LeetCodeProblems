package LeetCode.array.RemoveDuplicatesFromSortedArray_26;

/**
 * Created by Sergii on 25.07.2016.

 26. Remove Duplicates from Sorted Array
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        int last = nums.length - 1;
        while (i<last) {
            if(nums[i] == nums[i+1]) {
                for (int j=i; j<last; j++) {
                    nums[j]=nums[j+1];
                }
                last--;
            } else {
                i++;
            }
        }
        int len = last + 1;
        return len;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length<2) return nums.length;
        int i=1; // do not change nums[0]. Start updating from nums[1];
        for(int j=1; j<nums.length; j++) {
            if (nums[j-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;// do not inc i, because it was already incremented in for loop.
    }
}
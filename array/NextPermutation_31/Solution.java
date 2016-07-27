package LeetCode.array.NextPermutation_31;

import java.util.Arrays;

/**
 31. Next Permutation
 https://leetcode.com/problems/next-permutation/
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 Lexicographical permutation algorithm
 https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i=nums.length-1;
        // looking for the suffix
        while (i>0 && nums[i-1]>=nums[i]) i--;

        // number can not be increased
        if (i==0) {
            Arrays.sort(nums);
            return;
        }

        // nums[i] - is the head of suffix,
        // nums[i-1] - is the pivot
        int pivot = nums[i-1];

        // looking for the target to swap - first element in suffix greater than pivot
        // from right to left
        int j=nums.length-1;
        while (j>i && nums[j]<=pivot) j--;

        // swap target and pivot
        int temp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = temp;

        // revers suffix
        j=nums.length-1;
        while (i<j) {
            temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
            i++;
        }
    }
}
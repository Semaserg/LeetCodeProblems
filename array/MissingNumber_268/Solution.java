package LeetCode.array.MissingNumber_268;

import java.util.Arrays;

/**
 268. Missing Number
 https://leetcode.com/problems/missing-number/

 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {

    // xor solution
    public int missingNumber1(int[] nums) {
        int result = nums.length; //  because 1 element is missing, so max element in array == len, not len-1
        for (int i=0; i< nums.length; i++) {
            result ^=i;
            result ^=nums[i];
        }
        return result;
    }

    //https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
    public int missingNumber2(int[] nums) {// sum
        int len = nums.length;
        // don`t use (len-1)*(len)/2 because 1 element is missing, so max element in array == len, not len-1
        int sum = (len+1)*(len)/2;
        for (int num : nums) {
            sum -=num;
        }
        return sum;
    }

    // binary search, O(n*log n) because of Array.sort.
    public int missingNumber(int[] nums) {// sum
        Arrays.sort(nums); // n * log n
        int left = 0;
        int right = nums.length;
        while (left<right) {
            int mid=(left+right)/2;
            if (nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}

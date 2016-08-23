package LeetCode.bitManipulation.MajorityElement_169;

/*
169. Majority Element
https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element
is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element
always exist in the array.
*/
public class Solution {

    // Time complexity O(n), space complexity O(1).
    // Different implementation.
    // https://discuss.leetcode.com/topic/28601/java-solutions-sorting-hashmap-moore-voting-bit-manipulation
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm - Boyer–Moore majority vote algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int c : nums) {
            if (candidate == c) {
                count++;
            } else {
                if (count == 0) {
                    candidate = c;
                } else {
                    count--;
                }
            }
        }
        // Check is candidate really majority element.
        // We don`t need this because according to the task we have it.
//        count = 0;
//        for (int c : nums) {
//            if (c == candidate) count++;
//        }
        return candidate;
    }
}
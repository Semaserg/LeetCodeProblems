package LeetCode.array.TwoSum2_InputArrayIsSorted_167;

/**
 167. Two Sum II - Input array is sorted
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

 Given an array of integers that is already sorted in ascending order,
 find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such
 that they add up to the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are
 not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Solution {
    // Two pointers
    // Time complexity O(n), space complexity O(1);
    // Binary search O(n*log n) time complexity.
    // https://discuss.leetcode.com/topic/7465/a-less-efficient-way-binary-search
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) return new int[]{};
        int i = 0, j = numbers.length-1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[] {i+1, j+1};
            if (sum > target) { j--; }
            else { i++; }
        }
        return new int[]{};
    }
}
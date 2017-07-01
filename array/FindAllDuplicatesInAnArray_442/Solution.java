package LeetCode.array.FindAllDuplicatesInAnArray_442;

import java.util.ArrayList;
import java.util.List;

/**
 442. Find All Duplicates in an Array
 https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description

 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
// https://discuss.leetcode.com/topic/64908/java-solution-without-destroying-the-input-array-o-n-time-o-1-space
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) throw new IllegalArgumentException("ex");

        for (int i : nums) {
            int location = Math.abs(i) - 1; // index of element where we store the marker
            if (nums[location] < 0) result.add(Math.abs(i));
            else nums[location] = -nums[location]; // use -nums[location] like a marker that location item exists in nums
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] = Math.abs(nums[i]); // recover array
        }
        return result;
    }
}
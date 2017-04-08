package LeetCode.array.SearchInsertPosition_35;

/**
 35. Search Insert Position
 https://leetcode.com/problems/search-insert-position/

 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
// https://discuss.leetcode.com/topic/7874/my-8-line-java-solution
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length-1;
        while (left<rigth) {
            int mid = left + (rigth-left)/2;
            if (nums[mid] > target) rigth = mid-1;
            else if (nums[mid] < target) left = mid+1;
            else return mid;
        }
        // left=right => use any.
        if (nums[left] < target) return left+1;
        else return left;
    }
}
package LeetCode.array.SearchInRotatedSortedArray2_81;

/**
 81. Search in Rotated Sorted Array II
 https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class Solution {

    // Great solution
    // https://discuss.leetcode.com/topic/310/when-there-are-duplicates-the-worst-case-is-o-n-could-we-do-better/2
    // My solution
    // The common situation when pivot is in the middle [3,4,5,1,1,2,3]. 1 - is the pivot.
    // 1. When we calc the middle - compare it with left and right.
    // if it`s equals to left => int left till we found some element != to mid, or stop in mid.
    // Same for right - decrease it till mid, or any element != mid.
    // 2. (nums[lo] <= nums[mid]) - left part is sorted. if ( left <= target <= mid) - search in this part.
    // (nums[mid] <= nums[hi]) - right part is sorted. if ( mid <= target <= right) - search in this part.
    // 3. if target in not sorted part (with pivot somewhere inside) => check right and dec it, check left and inc it.
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) return true;
            // 1. check middle, left, right.
            if (nums[mid] == nums[lo]) {
                while (lo < mid && nums[lo] == nums[mid]) lo++;
            }
            if (nums[mid] == nums[hi]) {
                while (hi > mid && nums[hi] == nums[mid]) hi--;
            }
            // 2. find sorted part and search there
            if ((nums[lo] <= nums[mid]) && (target >= nums[lo] && target <=nums[mid])) {
                hi = mid-1;
            }
            else if ((nums[mid] <= nums[hi]) && (target >= nums[mid] && target <=nums[hi])) {
                lo = mid+1;
            }
            // if target in not sorted part (with pivot somewhere inside).
            else {
                if (nums[hi] == target) return true;
                else hi--;

                if (nums[lo] == target) return true;
                else lo++;
            }
        }
        return false;
    }
}
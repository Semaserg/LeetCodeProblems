package LeetCode.array.SearchInRotatedSortedArray_33;

/**
 33. Search in Rotated Sorted Array
 https://leetcode.com/problems/search-in-rotated-sorted-array/

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/3538/concise-o-log-n-binary-search-solution
    // https://discuss.leetcode.com/topic/16580/java-ac-solution-using-once-binary-search
    // Time complexity O(log n)
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = getPivot(nums);
        // we can search with binary search in two sets [pivot .. last] [first .. pivot-1].
//        int max = nums.length-1;
//        if (target >= nums[0] && target <= nums[pivot]) {
//            return binarySearch(nums, 0, pivot, target);
//        } else if (pivot < max && target >= nums[pivot+1] && target <= nums[max]){
//            return binarySearch(nums, pivot+1, max, target);
//        }
        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int realmid = (mid + pivot)%nums.length;
            if (nums[realmid] == target) return realmid;
            if (nums[realmid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private int getPivot(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[hi]) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
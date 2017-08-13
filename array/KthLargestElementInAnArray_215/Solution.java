package LeetCode.array.KthLargestElementInAnArray_215;

/**
 215. Kth Largest Element in an Array
 https://leetcode.com/problems/kth-largest-element-in-an-array/description/

 Find the kth largest element in an unsorted array.
 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ? k ? array's length.
 */
// use quick selection algorithm
// https://github.com/Semaserg/LeetCodeProblems/blob/master/sorting/QuickSort/QuickSelection.java
public class Solution {
    // got time limit exceeded
    public int findKthLargest1(int[] nums, int k) {
        if (k > nums.length) return 0;

        k = nums.length - k; // index of smallest element

        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot == k) return nums[pivot];
            else if (pivot < k) lo = pivot+1;
            else if (pivot > k) hi = pivot-1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int pivot = nums[lo];
        int l = lo + 1;
        int r = hi;
        while (true) {
            while (nums[l] < pivot) {
                l++;
                if (l >= hi) break;
            }

            while (nums[r] > pivot) {
                r--;
                if (r <= lo) break;
            }

            if (l >= r) break;
            swap(nums, l, r);
        }
        if (lo < r) swap(nums, lo, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // https://en.wikipedia.org/wiki/Quickselect
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return 0;

        // turn the task to find n-th smallest element
        k = nums.length - k;

        int left = 0, right = nums.length - 1;

        while (true) {
            if (left == right) return nums[left];
            int pivotIndex = left; // select pivot index between left and right
            int pivotUpdatedIndex = partition(nums, left, right, pivotIndex);
            if (pivotUpdatedIndex == k) return nums[k];
            else if (pivotUpdatedIndex < k) left = pivotUpdatedIndex + 1;
            else if (pivotUpdatedIndex > k) right = pivotUpdatedIndex - 1;
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        if (left == right) return left;
        int pivot = nums[pivotIndex];
        swap(nums, right, pivotIndex);

        int storeIndex = left;
        for(int i=left; i<= right-1; i++) { // because nums[right] is pivot now
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right); // move pivot to final position
        return storeIndex;
    }
}
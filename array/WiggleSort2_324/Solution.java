package LeetCode.array.WiggleSort2_324;

/**
 324. Wiggle Sort II
 https://leetcode.com/problems/wiggle-sort-ii/description/

 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {
    // https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
    // https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int mediane = findKthSmallest(nums, nums.length/2);
        int n = nums.length;

        // use dutch flag algorithm
        int left = 0, right = n - 1, curr = 0;
        while (curr <= right) {
            if (nums[ind(curr, n)] < mediane) {
                swap(nums, ind(curr, n), ind(left, n));
                left++;
                curr++;
            } else if (nums[ind(curr, n)] > mediane) {
                swap(nums, ind(curr, n), ind(right, n));
                right--;
            } else { // if equals
                curr++;
            }
        }
    }

    private int ind(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    // Got this from 215
    // https://en.wikipedia.org/wiki/Quickselect
    public int findKthSmallest(int[] nums, int k) {
        if (k > nums.length) return 0;
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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
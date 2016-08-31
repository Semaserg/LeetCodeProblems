package LeetCode.array.RotateArray_189;

import java.util.Arrays;

/**
 189. Rotate Array
 https://leetcode.com/problems/rotate-array/

 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Solution {
    // https://discuss.leetcode.com/topic/14341/easy-to-read-java-solution
    // Time complexity O(n)
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length<2 || k == 0) return;
        int n = nums.length;
        if (k>=n) k=k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            to--;
            from++;
        }
    }

    // Good solution
    // https://discuss.leetcode.com/topic/24283/a-7-line-time-o-n-in-place-solution-no-reversing
    // https://discuss.leetcode.com/topic/9801/summary-of-c-solutions/5
    // https://discuss.leetcode.com/topic/9801/summary-of-c-solutions
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length<2 || k < 1 || k%nums.length == 0) return;
        int n = nums.length;
        k %= n;//if (k>=n) k=k%n;
        int current = nums[0];
        int count = 0;
        int start = 0;
        int i = 0;
        // we should move n elements
        while(count < n) {
            i = (i+k)%n;
            int temp = nums[i];
            nums[i] = current;
            // if n%k == 0 => after one rotation cycle last element change the first one.
            // for instance: [1,2,3,4], k=2, move 1->3, 3->1, we done.
            // It means we should start rotation with the next element, 2 in our case: 2->4, 4->2.
            if (i == start) {
                start++;
                i = start;
                current = nums[i];
            } else {
                // if n%k != null, after one rotation cycle last element would not change the first.
                // for instance: [1,2,3], k=2. Cycle: 1->3, 3->2. so we just need to continue until count<n.
                // It means do one more move 2->1. We are done.
                current = temp;
            }
            count++;
        }
    }
}

package LeetCode.array.PartitionToKEqualSumSubsets_698;

import java.lang.reflect.Array;
import java.util.*;

/**
 https://leetcode.com/contest/leetcode-weekly-contest-54/problems/partition-to-k-equal-sum-subsets/
 698. Partition to K Equal Sum Subsets

 Given an array of integers nums and a positive integer k, find whether
 it's possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:
 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 Note:

 1 <= k <= len(nums) <= 16.
 0 < nums[i] < 10000.
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || nums.length < k) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum%k != 0) return false;
        int basketSize = sum/k;

        Arrays.sort(nums);
        int l=0, r = nums.length-1;
        int curr = 0, cnt = 0;
        while (l<=r) {
            int li = nums[l], ri = nums[r];
            if (curr + ri <= basketSize) {
                curr += ri;
                r--;
                if (curr == basketSize) {
                    cnt++;
                    curr = 0;
                }
            } else if (curr + li <=basketSize) {
                curr += li;
                l++;
                if (curr == basketSize) {
                    cnt++;
                    curr = 0;
                }
            } else return false;
        }
        return (cnt == k && r<=l);
    }
}
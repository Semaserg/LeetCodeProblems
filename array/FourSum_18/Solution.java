package LeetCode.array.FourSum_18;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 18. 4Sum
 https://leetcode.com/problems/4sum/description/

 Given an array S of n integers, are there elements a, b, c, and d in S
 such that a + b + c + d = target? Find all unique quadruplets in the
 array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<len-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<len-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int l=j+1, r = len-1;
                while (l<r) {
                    if (l>j+1 && nums[l] == nums[l-1]) {
                        l++;
                        continue;
                    }
                    if (r<len-1 && nums[r] == nums[r+1]) {
                        r--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {l++;}
                }
            }
        }
        return res;
    }
}
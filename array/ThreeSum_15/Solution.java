package LeetCode.array.ThreeSum_15;

import java.util.*;

/**
 15. 3Sum
 https://leetcode.com/problems/3sum/#/description

 Given an array S of n integers, are there elements a, b, c
 in S such that a + b + c = 0? Find all unique triplets in the array
 which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
// My NOT WORKING back tracking solution for any count in sum
public class Solution {
    private final int COUNT = 3;
    private Set<Integer> existed;
    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> threeSum(int[] nums) {
        this.result = new ArrayList<>();
        this.existed = new HashSet<>();
        this.nums = nums;
        Arrays.sort(this.nums);

        if (nums == null || nums.length == 0) return result;

        backTrack(0, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int start, int sum, List<Integer> currentList) {
        if (start >= nums.length) return;
        if (currentList.size() == COUNT) {
            if (sum == 0) {
                int hash = currentList.hashCode();
                if (existed.add(hash)) result.add(new ArrayList<>(currentList));
            }
            return;
        }
        for(int i=start; i<nums.length; i++) {
            int current = nums[i];
            System.out.println(current);
            currentList.add(current);
            backTrack(i+1, sum+current, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}

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
public class Solution1 {

    // https://discuss.leetcode.com/topic/8107/share-my-ac-c-solution-around-50ms-o-n-n-with-explanation-and-comments
    // O(n^2) time
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums == null || nums.length == 0) return result;

        for(int i=0; i<nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int target = 0 - curr;
            int left = i+1, right = nums.length-1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum>target) right--;
                else if (sum<target) left++;
                else {
                    int l = nums[left];
                    int r = nums[right];

                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(l);
                    list.add(r);
                    result.add(list);

                    while (left<right && nums[left] == l) left++;
                    while (left<right && nums[right] == r) right--;
                }
            }
        }
        return result;
    }

}

package LeetCode.backTracking.Subsets2_90;

import java.util.*;

/**
 90. Subsets II
 https://leetcode.com/problems/subsets-ii/

 Given a set of distinct integers, nums, return all possible subsets.
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Solution {
    // Good explanation
    // https://discuss.leetcode.com/topic/4661/c-solution-and-explanation/7
    // the idea to treat duplicates as special single element.
    // we should add such element to all of the existing arrays from 1 to count times
    // for instance, currently in res = [ [], [1] ], nums = [1,2,2], so count = 2 =>
    // we should add for [] array - [2], [2,2],
    // for [1] array - [1,2], [1,2,2].
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        // sort to keep similar together
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int item = nums[i];
            int count = 1;
            while (i+1<nums.length && nums[i] == nums[i+1]) {
                i++;
                count++;
            }
            int size = res.size();
            for(int j=0; j<size; j++) {
                List<Integer> current = res.get(j);
                for (int k=0; k<count; k++) {
                    List<Integer> next = new ArrayList<>(current);
                    next.add(item);
                    res.add(next);
                    current = next;
                }
            }
        }
        return res;
    }


    // https://discuss.leetcode.com/topic/22638/very-simple-and-fast-java-solution
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        bt(result, curr, 0, nums);
        return result;
    }

    private void bt(List<List<Integer>> res, List<Integer> curr, int index, int[] nums) {
        res.add(new ArrayList<>(curr));
        if (index >= nums.length) return;
        int i = index;
        while (i<nums.length) {
            curr.add(nums[i]);
            bt(res, curr, i+1, nums);
            curr.remove(curr.size()-1);
            i++;
            while (i>0 && i<nums.length && nums[i] == nums[i-1]) i++;
        }
    }
}

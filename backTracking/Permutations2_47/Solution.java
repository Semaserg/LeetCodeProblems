package LeetCode.backTracking.Permutations2_47;

import java.util.*;

/*
47. Permutations II
https://leetcode.com/problems/permutations-ii/#/description

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
//https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        bt(result, current, nums, new boolean[nums.length]);
        return result;
    }

    // in case of duplicates (a[i] == a[i-1]), we can use a[i] only if a[i-1] already used.
    // in other case duplicate sets be generated. like [1,2,1] [1,2,1].
    private void bt(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            used[i] = true;
            current.add(nums[i]);

            bt(result, current, nums, used);

            used[i] = false;
            current.remove(current.size()-1);
        }
    }
}
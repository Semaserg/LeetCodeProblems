package LeetCode.backTracking.Permutations_46;

import java.util.*;

/*
46. Permutations
https://leetcode.com/problems/permutations/#/description
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> source = new ArrayList<>(nums.length);
        for (int i : nums) source.add(i);
        bt(source, new ArrayList<>(), res);
        return res;
    }

    private void bt(List<Integer> source, List<Integer> current, List<List<Integer>> result) {
        if (source.isEmpty()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<source.size(); i++) {
            int item = source.get(i);
            List<Integer> nextSource = new ArrayList<>(source);
            nextSource.remove(i);
            current.add(item);

            bt(nextSource, current, result);
            current.remove(current.size()-1);
        }
    }
}
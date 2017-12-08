package LeetCode.backTracking.Combinations_77;

import java.util.*;

/*
https://leetcode.com/problems/combinations/description/
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k>n || k==0) return result;
        bt(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void bt(int c, int k, int n, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=c; i<=n; i++) {
            curr.add(i);
            bt(i+1, k, n, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
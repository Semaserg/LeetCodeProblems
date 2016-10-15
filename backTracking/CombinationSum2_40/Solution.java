package LeetCode.backTracking.CombinationSum2_40;

import java.util.*;

/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
public class Solution {
    // My solution
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        HashSet<String> set = new HashSet<String>();
        rec(candidates, target, 0, 0, curr, res, set);
        return res;
    }

    private void rec(int[] candidates, int target, int sum, int index, LinkedList<Integer> curr,
                     List<List<Integer>> res, HashSet<String> set) {
        if (sum > target) return;
        if (sum == target) {
            ArrayList<Integer> l = new ArrayList<>(curr);
            l.sort((a,b) -> a-b); // n*lon n
            String key = l.toString();
            if (!set.contains(key)) {
                res.add(l);
                set.add(key);
            }
        }
        for (int i=index; i<candidates.length; i++) {
            curr.add(candidates[i]);
            sum += candidates[i];
            rec(candidates, target, sum, i+1, curr, res, set);
            int last = curr.removeLast();
            sum -= last;
        }
    }

    // Good solution
    // https://discuss.leetcode.com/topic/19845/java-solution-using-dfs-easy-understand/2
    // Looks like time complexity O(n^n), space complexity - O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, curr, res);
        return res;
    }

    // this method is just a recursive tree, depth is - n, number of branches starts from the n-1 and decreasing to 0
    // Space complexity is O(n) - the depth of the recursive tree
    private void dfs(int[] candidates, int target, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i>index && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
package LeetCode.array.Subsets_78;

import java.util.ArrayList;
import java.util.List;

/**
 78. Subsets
 https://leetcode.com/problems/subsets/

 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
// Great bit manipulation solution.
// https://discuss.leetcode.com/topic/2764/my-solution-using-bit-manipulation
// https://discuss.leetcode.com/topic/19110/c-recursive-iterative-bit-manipulation-solutions-with-explanations
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        subsetRecursive(result, nums, 0);
        result.add(new ArrayList<>());
        return result;
    }

    // Time complexity -  O(n*2^n)
    // space complexity O(n) +  /stack because of recursion/ +  O(n*2^n) =>  O(n*2^n)
    // number of arrays is 2^n.
    private void subsetRecursive(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) return;
        subsetRecursive(result, nums, index+1);
        int size = result.size();
        for(int i=0; i<size; i++) {
            List<Integer> l = new ArrayList<>(result.get(i));
            l.add(nums[index]);
            result.add(l);
        }
        List<Integer> last = new ArrayList<>();
        last.add(nums[index]);
        result.add(last);
    }
}
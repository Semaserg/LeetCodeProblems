package LeetCode.array.CombinationSum3_216;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 216. Combination Sum III
 https://leetcode.com/problems/combination-sum-iii/

 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Example 1:
 Input: k = 3, n = 7

 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9

 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        int start = 0;
        int target = n;
        int length = k;
        combinationSumRecursive(start, length, target, result, current, nums);
        return result;
    }

    // https://discuss.leetcode.com/topic/37962/fast-easy-java-code-with-explanation - good explanation
    private void combinationSumRecursive(int start, int length, int target, List<List<Integer>> result,
                                                       List<Integer> current, int[] nums) {
        if (length == 0 && target == 0) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i=start; i<nums.length; i++) {
                if(target<0) break;
                current.add(nums[i]);
                int nextTarget = target - nums[i];
                int nextLength = length - 1;
                combinationSumRecursive(i+1, nextLength, nextTarget, result, current, nums);
                current.remove(current.size()-1);
            }
        }
    }
}

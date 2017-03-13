package LeetCode.math.RandomPickIndex_398;

import java.util.Random;

/*
398. Random Pick Index
https://leetcode.com/problems/random-pick-index/?tab=Description

Given an array of integers with possible duplicates, randomly output the index of a given target number.
You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/
public class Solution {
    private int[] nums;
    private Random rnd;
    // Set of solutions
    // https://discuss.leetcode.com/topic/58301/simple-reservoir-sampling-solution
    // https://discuss.leetcode.com/topic/58322/what-on-earth-is-meant-by-too-much-memory
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                count++;
                int randomEl = rnd.nextInt(count);
                if (randomEl == 0) result = i;
            }
        }
        return result;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
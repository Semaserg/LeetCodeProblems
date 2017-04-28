package LeetCode.array.ShuffleAnArray_384_;

import java.util.Random;
import java.util.Stack;

/**
 384. Shuffle an Array
 https://leetcode.com/problems/shuffle-an-array/#/description

 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result.
 // Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class Solution {
    private Random random;
    private Stack<Integer> stack;
    private int[] nums;

    public Solution(int[] nums) {
        random = new Random();
        stack = new Stack<>();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset1() {
        if (stack.isEmpty()) return nums;
        for (int i=nums.length-1; i>=0; i--) {
            int prevRndIndex =  stack.pop();
            int tmp = nums[i];
            nums[i] = nums[prevRndIndex];
            nums[prevRndIndex] = tmp;
        }
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle1() {
        for (int i=0; i<nums.length; i++) {
            int rndIndex =  random.nextInt(nums.length);
            stack.push(rndIndex);
            int tmp = nums[i];
            nums[i] = nums[rndIndex];
            nums[rndIndex] = tmp;
        }
        return nums;
    }

    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    // https://discuss.leetcode.com/topic/53978/first-accepted-solution-java
    public int[] shuffle() {
        int[] res = this.nums.clone();
        for (int i=0; i<nums.length; i++) {
            int rndIndex =  random.nextInt(nums.length-i) + i; // gives random in range [i..nums.length-1]
            int tmp = res[i];
            res[i] = res[rndIndex];
            res[rndIndex] = tmp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
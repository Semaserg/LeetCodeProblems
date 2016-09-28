package LeetCode.array.JumpGame_55;

/**
 55. Jump Game
 https://leetcode.com/problems/jump-game/

 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class Solution {
    // My stupid solution
    // time complexity O(n^2), space complexity O(n) - because of recursion.
    // Time limit exception on big input.
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return check(0, nums);
    }

    private boolean check(int index, int[] nums) {
        if (index >= nums.length-1) return true;
        int target = nums[index];
        if (target == 0) return false;
        for (int i=target; i>0; i--) {
            int nextIndex = index + i;
            if (check(nextIndex, nums)) return true;
        }
        return false;
    }

    // Great explanation
    // https://discuss.leetcode.com/topic/19931/6-line-java-solution-in-o-n
    // Time complexity O(n), space - O(1).
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; i++){
            if (i>reachable) return false;
            reachable = Math.max(i+nums[i], reachable);
        }
        return true;
    }
}
package LeetCode.hashtable.ContainsDuplicate2_219;

import java.util.HashMap;

/*
219. Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/

Given an array of integers and an integer k, find out whether
there are two distinct indices i and j in the array such that
nums[i] = nums[j] and the difference between i and j is at most k.
*/
// Time complexity O(n), space complexity O(n).
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            Integer saved = map.get(current);
            if (saved != null && Math.abs(i - saved) <= k) return true;
            map.put(current, i);
        }
        return false;
    }
}
// Great solution
// https://discuss.leetcode.com/topic/15305/simple-java-solution
// The basic idea is to maintain a set s which contain unique values from nums[i - k] to nums[i - 1],
// if nums[i] is in set s then return true else update the set.
// So we can reduce space complexity to store only k items maximum in a hashmap.
// And we can use HashSet in this case.
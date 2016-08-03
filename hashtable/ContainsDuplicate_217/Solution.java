package LeetCode.hashtable.ContainsDuplicate_217;

import java.util.HashSet;

/*
217. Contains Duplicate
https://leetcode.com/problems/contains-duplicate/

Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
https://discuss.leetcode.com/topic/14730/possible-solutions - bunch of interesting solutions
- sort and compare n[i] with n[i+1]
-  Arrays.stream(nums).distinct().count() - compare with array langth
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}
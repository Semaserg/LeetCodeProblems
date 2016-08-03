package LeetCode.hashtable.IntersectionOfTwoArrays_349;

import java.util.HashSet;

/*
349. Intersection of Two Arrays
https://leetcode.com/problems/intersection-of-two-arrays/

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);
        HashSet<Integer> resultSet = new HashSet<>();
        for(int j : nums2) {
            if (set.contains(j)) resultSet.add(j);
        }
        int[] result = new int[resultSet.size()];
        int k=0;
        for (int item : resultSet) result[k++] = item;
        return result;
    }
}
package LeetCode.array.IntersectionOfTwoArrays2_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 350. Intersection of Two Arrays II
 https://leetcode.com/problems/intersection-of-two-arrays-ii/

 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you
 cannot load all elements into the memory at once?

 https://discuss.leetcode.com/topic/45893/c-hash-table-solution-and-sort-two-pointers-solution-with-time-and-space-complexity
 time complexity O(log n + log m + m + n) - I`m not really sure
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]<nums2[j]) i++;
            else if (nums1[i]>nums2[j]) j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int ind=0;
        for (int k : list) res[ind++]=k;
        return res;
    }
}
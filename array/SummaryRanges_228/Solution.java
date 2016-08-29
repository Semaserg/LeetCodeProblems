package LeetCode.array.SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;

/**
 228. Summary Ranges
 https://leetcode.com/problems/summary-ranges/

 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
// Time complexity O(n), space complexity O(n) - to hold the result.
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int min=nums[0], max=nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]+1) { max = nums[i]; }
            else {
                if (min == max) { res.add(min + ""); }
                else { res.add(min + "->" + max); }
                min = nums[i];
                max = nums[i];
            }
        }
        if (min == max) { res.add(min + ""); }
        else { res.add(min + "->" + max); }
        return res;
    }
}
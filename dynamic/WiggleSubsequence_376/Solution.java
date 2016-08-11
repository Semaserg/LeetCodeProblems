package LeetCode.dynamic.WiggleSubsequence_376;

import java.util.ArrayList;
import java.util.List;

/*
376. Wiggle Subsequence
https://leetcode.com/problems/wiggle-subsequence/

A sequence of numbers is called a wiggle sequence if the differences between successive
 numbers strictly alternate between positive and negative. The first difference (if one exists)
 may be either positive or negative. A sequence with fewer than two elements is trivially
 a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3)
 are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle
 sequences, the first because its first two differences are positive and the second because its
  last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original
  sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?
*/
// Time complexity ???, space complexity ???.
public class Solution {
    // Time complexity O(n), space complexity O(n)
    public int wiggleMaxLength1(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int el : nums) list.add(el);
        int i=1;
        while (i<list.size()-1) {
            int leftDiff = list.get(i)-list.get(i-1);
            int rightDiff = list.get(i+1)-list.get(i);
            if (leftDiff*rightDiff >=0) list.remove(i);
            else i++;
        }
        // in case only two elements in the list with the same value;
        if (list.get(0)==list.get(1)) list.remove(1);
        return list.size();
    }

    // Good explanation
    // https://discuss.leetcode.com/topic/51946/very-simple-java-solution-with-detail-explanation
    // Nice implementation
    // https://discuss.leetcode.com/topic/51816/concise-c-0ms-o-n-solution-with-explanation/5
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        int direction = 0; // 1 - up, -1 - down
        int resIndex = 0;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            int diff = curr-prev;
            if (diff>0 && direction>=0) {
                resIndex++;
                direction = -1;
                // in case need to print sequence
                //nums[resIndex] = curr;
            } else if (diff<0 && direction<=0) {
                resIndex++;
                direction = 1;
                // in case need to print sequence
                //nums[resIndex] = curr;
            }
            prev = curr;
        }
        // in case need to print sequence, print 0..resIndex items from nums
        return resIndex+1;
    }

}
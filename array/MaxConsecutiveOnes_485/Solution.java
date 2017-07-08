package LeetCode.array.MaxConsecutiveOnes_485;

import java.util.PriorityQueue;

/**
 485. Max Consecutive Ones
 https://leetcode.com/problems/max-consecutive-ones/#/description

 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxCounter = 0;
        for (int i : nums) {
            if (i == 1) {
                counter++;
                maxCounter = Math.max(counter, maxCounter);
            } else {
                counter = 0;
            }
        }
        return maxCounter;
    }
}

package LeetCode.array.LongestConsecutiveSequence_128;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 128. Longest Consecutive Sequence
 https://leetcode.com/problems/longest-consecutive-sequence/

 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class Solution {
    // O(n^2) time complexity, O(n) space complexity.
    public int longestConsecutive1(int[] nums) {
        Hashtable<Integer,Integer> tab = new Hashtable<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
            tab.put(nums[i],1);
        }
        Set<Integer> keys = tab.keySet();
        for (Integer key : keys) {
            int j = key+1;
            int len = 1;
            while (tab.containsKey(j)) {
                len++;
                j++;
            }
            tab.put(key,len);
        }
        int max = 0;
        for(Integer val : tab.values()) {
            if (val > max) max = val;
        }
        return max;
    }

    // O(n) time complexity
    // https://discuss.leetcode.com/topic/15383/simple-o-n-with-explanation-just-walk-each-streak
    // https://discuss.leetcode.com/topic/25493/simple-fast-java-solution-using-set
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer item : set) {
            // check that current item is the beginning of the sequence -> no element before current.
            if (!set.contains(item-1)) {
                int localMax = 1;
                int i = item+1;
                while (set.contains(i)) {
                    localMax++;
                    i++;
                }
                if (localMax > max) max = localMax;
            }
        }
        return max;
    }
}
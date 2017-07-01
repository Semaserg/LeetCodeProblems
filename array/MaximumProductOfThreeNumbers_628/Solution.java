package LeetCode.array.MaximumProductOfThreeNumbers_628;

import java.util.PriorityQueue;

/**
 628. Maximum Product of Three Numbers
 https://leetcode.com/problems/maximum-product-of-three-numbers/#/description

 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
// https://discuss.leetcode.com/topic/93690/java-easy-ac - sort and take top 3 ot [0],[1] and last.
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // min heap
        PriorityQueue<Integer> holdsMaxThreeItems = new PriorityQueue<>((a,b) -> a - b);
        // max heap
        PriorityQueue<Integer> holdsMinTwoItems = new PriorityQueue<>((a,b) -> b - a);

        for (int i: nums) {
            holdsMaxThreeItems.add(i);
            holdsMinTwoItems.add(i);
            if (holdsMaxThreeItems.size() > 3) holdsMaxThreeItems.remove();
            if (holdsMinTwoItems.size() > 2) holdsMinTwoItems.remove();
        }

        int twoMin = holdsMinTwoItems.remove() * holdsMinTwoItems.remove();
        int twoMax = holdsMaxThreeItems.remove() * holdsMaxThreeItems.remove();
        int max = holdsMaxThreeItems.remove();
        return Math.max(twoMax * max, twoMin * max);
    }
}

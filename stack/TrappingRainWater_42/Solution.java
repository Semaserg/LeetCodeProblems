package LeetCode.stack.TrappingRainWater_42;

import java.util.Stack;

/*
42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation
map where the width of each bar is 1, compute how much
water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

http://articles.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
*/
public class Solution {
    // My stupid not working solution
    // O(n^2) time complexity
    public int trap1(int[] height) {
        if (height == null || height.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);
        int waterTotally = 0;
        for (int i=1; i<height.length; i++) {
            if (height[i] <= height[i-1]) {
                stack.push(height[i]);
            } else {
                int waterLevel = 0, poolWidth = 0;
                do {
                    poolWidth = 0;
                    while (!stack.isEmpty() && stack.peek()==height[i-1]) {
                        int prev = stack.pop();
                        poolWidth++;
                    }
                    int prevWallH = stack.isEmpty() ? 0 : stack.peek();
                    int nextWallH = height[i];
                    waterLevel = Math.min(prevWallH, nextWallH);
                    waterTotally += waterLevel * poolWidth;
                    // cover the pool with concrete, to check the next level.
                    for (int j=0; j<poolWidth; j++) {
                        stack.push(waterLevel);
                    }
                } while (waterLevel > 0 && poolWidth > 0);
                stack.push(height[i]);
            }
        }
        return waterTotally;
    }

    // https://discuss.leetcode.com/topic/3016/share-my-short-solution
    // https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
    // Time complexity O(n)
    // Space complexity O(1)
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int total = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                total += maxLeft - height[left];
                left++;
            } else {
                total += maxRight - height[right];
                right--;
            }
        }
        return total;
    }
}
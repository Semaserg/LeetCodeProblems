package LeetCode.array.RemoveElement_27;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii on 25.07.2016.
 27. Remove Element
 https://leetcode.com/problems/remove-element/

 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        for(int i = nums.length-1; i>=0; i--) {
            if (nums[i] == val) {
                int temp = nums[last];
                nums[last] = nums[i];
                nums[i] = temp;
                last--;
            }
        }
        int length = ++last;
        return length;
    }
}
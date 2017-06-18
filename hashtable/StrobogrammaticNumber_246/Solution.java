package LeetCode.hashtable.StrobogrammaticNumber_246;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
246. Strobogrammatic Number
https://leetcode.com/problems/strobogrammatic-number/#/description

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

// https://discuss.leetcode.com/topic/21576/accepted-java-solution
public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('9', '6');
        map.put('6', '9');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
        int left = 0, right = num.length()-1;
        while (left <= right) {
            char leftChar = num.charAt(left), rightChar = num.charAt(right);
            if (!map.containsKey(leftChar)) return false;
            if (map.get(leftChar) == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
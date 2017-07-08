package LeetCode.array.LargestNumber_179;

import java.util.ArrayList;
import java.util.Arrays;

/**

 179. Largest Number
 https://leetcode.com/problems/largest-number/#/description

 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */
// https://discuss.leetcode.com/topic/7235/my-3-lines-code-in-java-and-python
// https://discuss.leetcode.com/topic/8018/my-java-solution-to-share
public class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(str, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        if (str[0].charAt(0) == '0') return "0"; // if only zeros in array

        StringBuilder sb = new StringBuilder();
        for (String s: str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
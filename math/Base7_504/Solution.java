package LeetCode.math.Base7_504;

/*
504. Base 7
https://leetcode.com/problems/base-7/#/description

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
*/

// Info
// http://mathworld.wolfram.com/Base.html
// http://www.purplemath.com/modules/numbbase2.htm
// https://www.youtube.com/watch?v=4lQPwn_NY20
// Solutions
// https://discuss.leetcode.com/topic/78972/simple-java-oneliner-ruby
// https://discuss.leetcode.com/topic/78952/verbose-java-solution
public class Solution {
    // iterative
    public String convertToBase7_iter(int num) {
        if (num == 0) return "0";
        if (num < 0) return "-" + convertToBase7(-num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num%7);
            num /= 7;
        }
        return sb.toString();
    }

    //recursive
    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return "" + num;
        return convertToBase7(num/7) + num%7;
    }
}
package LeetCode.math.FactorialTrailingZeroes_172;

import java.util.ArrayList;
import java.util.HashMap;

/*
172. Factorial Trailing Zeroes
https://leetcode.com/problems/factorial-trailing-zeroes/

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all Snake_3 cases.

Subscribe to see which companies asked this question
*/
public class Solution {
    // https://discuss.leetcode.com/topic/6513/simple-c-c-solution-with-detailed-explaination
    // https://discuss.leetcode.com/topic/6516/my-one-line-solutions-in-3-languages/10
    public int trailingZeroes(int n) {
        // each trailing 0 is 2*5. So we need to calc 2 and 5 factors in n!
        // each even number is dividable by 2. So we have enough 2th.
        // let`s calculate 5th.
        int countOf5 = 0;
        while (n >= 5) { // calc how much nums in n! contains factor 5.
            countOf5 += n/5;
            n /= 5;
        }
        return countOf5;
    }
}
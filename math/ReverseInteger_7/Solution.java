package LeetCode.math.ReverseInteger_7;

/*
7. Reverse Integer
https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to Snake_3 the overflow behavior.
*/
public class Solution {
    // Time complexity O(n), n - str len of the x.
    // Good solution
    // https://discuss.leetcode.com/topic/6104/my-accepted-15-lines-of-code-for-java
    public int reverse(int x) {
        int res = 0;
        int sign = (x<0) ? -1 : 1;
        x=x*sign;
        while (x>0) {
            int rem = x%10;
            x=x/10;
            double max = (Integer.MAX_VALUE-rem)/10;
            if (res > max) return 0;
            res = res*10 + rem;
        }
        return res*sign;
    }
}
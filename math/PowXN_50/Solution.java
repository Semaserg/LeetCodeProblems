package LeetCode.math.PowXN_50;

/*
50. Pow(x, n)
https://leetcode.com/problems/powx-n/

Implement pow(x, n).
*/
public class Solution {
    /**
     * 1. We should reduce number of * operations, because of
     * a) efficiency
     * b) accumulated error when looks like x.000000023423
     * We cen do it next way:
     * 2^16 = 2^8*2^8 = (2*2)^8 = 4^8 = 4^4 * 4^4 = (4*4)^4 = 16^4 ...
     * when n%2==1 => 2^5 = 2^1 *2^2 *2^2 = 2 * (2*2)^2
     * 2. In case of negative power, for instance n=-3, x^-3 = 1/(x^3) = (1/3)^3 =>
     * just need to switch: n=-n , x=1/x;
     */
    // Set of solutions
    // https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers/2
    // https://discuss.leetcode.com/topic/5425/short-and-easy-to-understand-solution/3
    public double myPow(double x, int n) {
        // infinity check
        // Integer.MIN_VALUE can`t be converted to Integer.MAX_VALUE like this n=-n,
        // because Integer.MIN_VALUE = -2....8, Integer.MAX_VALUE = 2......7
        // interesting solution for this case:
        // https://discuss.leetcode.com/topic/49936/java-iterative-solution-eliminates-stack-space-in-recursion
        // Time complexity O(log n) - because of each iteration we are dividing power by 2.
        // Space complexity O(log n) - because of recursion.
        if (n == Integer.MAX_VALUE && (x>1 || x<-1)) return 0.0;
        if (n == Integer.MIN_VALUE) {
            if (x == 0.0) return 0.0;
            if (x == 1.0) return 1.0;
            if (x == -1.0) return 1.0;
            return 0.0;
        }
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        if (n%2 == 0) {
            return myPow(x*x, n/2);
        } else {
            return  x*myPow(x*x, n/2);
        }
    }
}
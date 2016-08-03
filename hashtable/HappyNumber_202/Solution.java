package LeetCode.hashtable.HappyNumber_202;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 202. Happy Number
 https://leetcode.com/problems/happy-number/
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number
 equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers
 for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 Explanations
 https://discuss.leetcode.com/topic/30520/explanation-of-why-those-posted-algorithms-are-mathematically-valid
 https://discuss.leetcode.com/topic/42746/all-you-need-to-know-about-testing-happy-number
 (1) for a positive integer n, n is either a happy number or unhappy with
 cycle length 7.

 (2) digitSquareSum(n) < n for all n>99

 (3) there are 19 happy numbers and 80 unhappy numbers in [1,99]

 (4) happyNumLess100 = [1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70,
 79, 82, 86, 91, 94, 97]

 (5) for these numbers the corresponding update count to become 1 is stepcnt = [0, 5,
 1, 2, 4, 3, 3, 2, 3, 4, 4, 2, 5, 3, 3, 2, 4, 4, 3]

 https://discuss.leetcode.com/topic/12742/o-1-space-java-solution -  walker-runner solution.
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int next = digitSquareSum(n);
            if (next == 1) return true;
            else if (set.contains(next)) return false;
            else {
                set.add(next);
                n = next;
            }
        }
    }

    // http://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number - get digits of number
    private int digitSquareSum(int n) {
        int res = 0;
        while (n>0) {
            int reminder = n%10;
            res += reminder*reminder;
            n = n/10;
        }
        return res;
    }
}
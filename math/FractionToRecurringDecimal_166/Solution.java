package LeetCode.math.FractionToRecurringDecimal_166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
166. Fraction to Recurring Decimal
https://leetcode.com/problems/fraction-to-recurring-decimal/

Given two integers representing the numerator and denominator of a fraction
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
Be wary of edge cases! List out as many Snake_3 cases as you can think of and Snake_3 your code thoroughly.
*/
public class Solution {

    // Divide numerator / denominator like in a paper.
    // when we have again the same subtraction - it means we have a repeatable portion.
    // so we should save in hashMap subtraction result and position, to insert "(" in correct place.
    public String fractionToDecimal1(int numerator, int denominator) {

        String sign = ((numerator >= 0 && denominator >= 0) || (numerator <= 0 && denominator <= 0)) ? "" : "-";
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        long res = n/d;
        String beforeDot = sign + res;
        long rem = n%d;
        if (rem == 0) return beforeDot;

        ArrayList<Long> afterDot = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();

        long subtractionRes = n - res*d;
        int counter = 0;
        map.put(subtractionRes, counter);
        n = 10 * subtractionRes;
        counter++;

        while (rem != 0) {
            res = n/d;
            rem = n%d;
            subtractionRes = n - res*d;
            if (map.containsKey(subtractionRes)) {
                afterDot.add(map.get(subtractionRes), Long.MIN_VALUE);
                afterDot.add(res);
                afterDot.add(Long.MAX_VALUE);
                break;
            } else {
                afterDot.add(res);
                map.put(subtractionRes, counter);
                counter++;
                n = subtractionRes * 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (long i : afterDot) {
            if (i == Long.MIN_VALUE) sb.append("(");
            else if (i == Long.MAX_VALUE) sb.append(")");
            else sb.append(i + "");
        }
        return beforeDot + "." + sb.toString();
    }

    // Good solution
    // https://discuss.leetcode.com/topic/7876/my-clean-java-solution
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        String sign = ( (numerator > 0) ^ (denominator > 0) ) ? "-" : "";

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        StringBuilder result = new StringBuilder();
        result.append(sign);

        // add integral part
        result.append(n/d);
        n %=d;
        if (n == 0) return result.toString();

        // add fractional part
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>(); // Map<remainder, position in string builder>
        map.put(n, result.length());
        while (n != 0) {
            n *= 10;
            result.append(n/d);
            n %= d;
            if (map.containsKey(n)) {
                result.insert(map.get(n), "(");
                result.append(")");
                break;
            } else {
                map.put(n, result.length());
            }
        }
        return result.toString();
    }
}
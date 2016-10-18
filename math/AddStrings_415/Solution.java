package LeetCode.math.AddStrings_415;

/*
415. Add Strings
https://leetcode.com/problems/add-strings/

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class Solution {
    public String addStrings1(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("num1 and num2 should not be null");
        }
        int len = Math.max(num1.length(), num2.length());
        int diff1 = len - num1.length();
        int diff2 = len - num2.length();
        int remainder = 0;
        StringBuilder result = new StringBuilder();
        for(int i = len - 1; i >= 0; i--) {
            String st1 = (i - diff1 >= 0) ? num1.substring(i - diff1, i - diff1 + 1) : "0";
            String st2 = (i - diff2 >= 0) ? num2.substring(i - diff2, i - diff2 + 1) : "0";
            int n1 = Integer.parseInt(st1);
            int n2 = Integer.parseInt(st2);
            int sum = n1 + n2 + remainder;
            result.insert(0, sum%10);
            remainder = sum/10;
        }
        if (remainder > 0) result.insert(0, remainder);
        return result.toString();
    }

    // Small improvements
    // https://discuss.leetcode.com/topic/62310/straight-forward-java-10-main-lines-25ms
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("num1 and num2 should not be null");
        }

        int carry = 0;
        StringBuilder result = new StringBuilder();

        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >=0; i--, j--) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            result.insert(0, sum%10);
            carry = sum/10;
        }
        if (carry > 0) result.insert(0, carry);
        return result.toString();
    }
}

package LeetCode.math.IntegerToRoman_12;

/*
12. Integer to Roman
https://leetcode.com/problems/integer-to-roman/

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
// Roman numbers
// https://en.wikipedia.org/wiki/Roman_numerals
// Amazing solution
// https://discuss.leetcode.com/topic/12384/simple-solution
public class Solution {
    public String intToRoman(int num) {
        int[] digits = new int[4];
        int index = 0;
        while (num>0) {
            digits[index++] = num%10;
            num /=10;
        }
        StringBuilder sb = new StringBuilder();
        sb.insert(0, digitToStr(digits[0], "I", "V", "X"));
        sb.insert(0, digitToStr(digits[1], "X", "L", "C"));
        sb.insert(0, digitToStr(digits[2], "C", "D", "M"));
        sb.insert(0, rep("M", digits[3]));
        return sb.toString();
    }

    private String digitToStr(int digit, String one, String five, String ten) {
        if (digit >= 0 && digit <= 3) return rep(one, digit);
        if (digit == 4) return one+five;
        if (digit >=5 && digit <=8) return five+rep(one, digit-5);
        if (digit == 9) return one+ten;
        return "";
    }

    private String rep(String c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<times; i++) sb.append(c);
        return sb.toString();
    }
}
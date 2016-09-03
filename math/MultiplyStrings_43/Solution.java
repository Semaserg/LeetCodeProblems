package LeetCode.math.MultiplyStrings_43;

/*
43. Multiply Strings
https://leetcode.com/problems/multiply-strings/

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
*/
public class Solution {
    // Good examples
    // https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
    // https://discuss.leetcode.com/topic/13026/ac-solution-in-java-with-explanation
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        int index = -1;
        for (int i=len2-1; i>=0; i--) {
            int currIndex = ++index;
            for (int j=len1-1; j>=0; j--) {
                int r = (num2.charAt(i)-'0') * (num1.charAt(j) - '0') + res[currIndex];
                res[currIndex] = r%10;
                res[currIndex+1] += r/10;
                currIndex++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int firstDigit = res.length-1;
        while (res[firstDigit] == 0 && firstDigit>0) firstDigit--;
        for(int i=firstDigit; i>=0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
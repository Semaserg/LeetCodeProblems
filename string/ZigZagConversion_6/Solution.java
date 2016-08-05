package LeetCode.string.ZigZagConversion_6;

import java.util.HashMap;

/*
6. ZigZag Conversion
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
// Time complexity O(n), space complexity O(n).
public class Solution {
    // http://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
    // https://discuss.leetcode.com/topic/41037/java-solution-easy-and-clear-interesting-approach
    public String convert(String s, int numRows) {
        if (numRows <=1) return s;
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
           sbArray[i] = new StringBuilder();
        }
        int index = 0, inc = 1;
        for (int i=0; i<s.length(); i++) {
            sbArray[index].append(s.charAt(i));
            if (index == 0) inc=1;
            else if (index == numRows-1) inc=-1;
            index +=inc;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            res.append(sbArray[i]);
        }
        return res.toString();
    }
}
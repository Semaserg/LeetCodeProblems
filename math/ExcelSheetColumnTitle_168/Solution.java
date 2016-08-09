package LeetCode.math.ExcelSheetColumnTitle_168;

/*
168. Excel Sheet Column Title
https://leetcode.com/problems/excel-sheet-column-title/

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/
public class Solution {
    // Good explanation
    // https://discuss.leetcode.com/topic/35360/my-easy-to-understand-java-solution/4
    public String convertToTitle(int n) {
        // 0 -> A -> 65+0
        // 25 -> Z -> 65+25
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            int rem = (n-1)%26;
            sb.append((char)('A' + rem));
            n=(n-1)/26;
        }
        return sb.reverse().toString();
    }
}
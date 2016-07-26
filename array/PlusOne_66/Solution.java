package LeetCode.array.PlusOne_66;

/**
 * Created by Sergii on 25.07.2016.

 66. Plus One
 https://leetcode.com/problems/plus-one/
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while(i>=0) {
            if(digits[i]==9) {
                digits[i]=0;
                i--;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
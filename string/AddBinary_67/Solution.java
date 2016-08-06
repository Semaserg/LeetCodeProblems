package LeetCode.string.AddBinary_67;

/*
67. Add Binary
https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {

    // My big stupid solution
    public String addBinary1(String a, String b) {
        if (a.length()==0 && b.length()==0) return "";
        char[] firstArr = (a.length() >= b.length()) ? a.toCharArray() : b.toCharArray();
        char[] secondArr = (a.length() < b.length()) ? a.toCharArray() : b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        int diff = firstArr.length - secondArr.length;
        for (int i=firstArr.length-1; i>=0; i--) {
            int secondIndex = i-diff;
            int a1 = Integer.parseInt(String.valueOf(firstArr[i]));
            int a2 = secondIndex>=0 ? Integer.parseInt(String.valueOf(secondArr[secondIndex])) : 0;
            int res = reminder + a1 + a2;
            switch (res) {
                case 0:
                    sb.append('0');
                    reminder = 0;
                    break;
                case 1:
                    sb.append('1');
                    reminder = 0;
                    break;
                case 2:
                    sb.append('0');
                    reminder = 1;
                    break;
                case 3:
                    sb.append('1');
                    reminder = 1;
                    break;
            }
        }
        if (reminder == 1) sb.append('1');
        return sb.reverse().toString();
    }

    // Good solution
    // https://discuss.leetcode.com/topic/13698/short-ac-solution-in-java-with-explanation/2
    public String addBinary(String a, String b) {
        if (a.length()==0 && b.length()==0) return "";
        StringBuilder result = new StringBuilder();
        int i=a.length()-1, j=b.length()-1, remainder=0;
        while (i>=0 || j>=0) {
            int res = 0;
            // about a.charAt(i--)-'0';
            //http://stackoverflow.com/questions/4318263/java-subtract-0-from-char-to-get-an-int-why-does-this-work
            if (i>=0) {
                res += a.charAt(i)-'0';
                i--;
            }
            if (j>=0) {
                res += b.charAt(j)-'0';
                j--;
            }
            res+=remainder;
            result.append(res%2);
            remainder=res/2;
        }
        if (remainder==1) result.append(1);
        return result.reverse().toString();
    }
}
package LeetCode.string.CountBinarySubstrings_696;

import java.util.HashMap;
import java.util.Map;

/*
696. Count Binary Substrings
https://leetcode.com/contest/leetcode-weekly-contest-54/problems/count-binary-substrings/

Give a string s, count the number of non-empty (contiguous) substrings
that have the same number of 0's and 1's, and all the 0's and all the
1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive
1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.
*/
class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int counter = 0;
        for (int i=0; i<s.length()-1; i++) {
            char a = s.charAt(i), b = s.charAt(i+1);
            if ((a == '0' && b == '1') || (a == '1' && b == '0')) {
                int l = i, r = i+1;
                while(l>=0 && r<s.length() && s.charAt(l) == a && s.charAt(r) == b) {
                    counter++;
                    l--;
                    r++;
                }
            }
        }
        return counter;
    }
}
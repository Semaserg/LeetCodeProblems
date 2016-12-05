package LeetCode.math.SelfCrossing_335;

/*
335. Self Crossing
https://leetcode.com/problems/self-crossing/

You are given an array x of n positive numbers.
You start at point (0,0) and moves x[0] metres to the north,
then x[1] metres to the west, x[2] metres to the south, x[3]
metres to the east and so on. In other words, after each move
your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine,
if your path crosses itself, or not.

Example 1:
Given x =
[2, 1, 1, 2]
,
┌───┐
│   │
└───┼──>
    │

Return true (self crossing)
Example 2:
Given x =
[1, 2, 3, 4]
,
┌──────┐
│      │
│
│
└────────────>

Return false (not self crossing)
Example 3:
Given x =
[1, 1, 1, 1]
,
┌───┐
│   │
└───┼>

Return true (self crossing)*/
public class Solution {
    /*
    There two cases when lines are crossing
    Case 1:
    ┌───┐
    │     │
    └───┼>
    this case contains 4 lines, let's call: 1st line len - a, 2nd - b, 3rd - c, 4th - d.
    lines are crossing if: a >= c && d >= b

    Case 2:
    ┌───┐
    │    ─|─┐
    │         │
    └───-─-|
    this case contains 6 lines, let's call: 5rd - e, 6th - f.
    lines are crossing if: b <= d && e <= c && a >= c-e && f >= d-b

    All we should do check one-by-one 4-size portions (case 1) and 6-size portions (case 2)
    for all the items in x array.
     */
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if(len < 4) return false;
        for (int l = 0; l <= x.length-4; l++) {
            int a = x[l];
            int b = x[l+1];
            int c = x[l+2];
            int d = x[l+3];
            int e = (l+4 < len) ? x[l+4] : 0;
            int f = (l+5 < len) ? x[l+5] : 0;
            if ((a >= c && d >= b) || (b <= d && e <= c && a >= c-e && f >= d-b)) {
                return true;
            }
        }
        return false;
    }
}
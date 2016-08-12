package LeetCode.binarySearch.GuessNumberHigherOrLower_374;

/*
374. Guess Number Higher or Lower
https://leetcode.com/problems/guess-number-higher-or-lower/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution {
    public int guessNumber(int n) {
        int lo=1;
        int hi=n;
        while (lo<hi) {
            int mid = lo + (hi-lo)/2;
            int g = guess(mid);
            if (g>0) {
                lo = mid+1;
            } else if (g<0) {
                hi = mid-1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private int guess(int num) {
        return 0;
    }
}
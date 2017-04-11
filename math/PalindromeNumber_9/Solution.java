package LeetCode.math.PalindromeNumber_9;

/*
9. Palindrome Number
https://leetcode.com/problems/palindrome-number/

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
you know that the reversed integer might overflow. How would you handle such case?
*/
public class Solution {
    // My stupid solution
    public boolean isPalindrome1(int x) {
        if (x<0) return false;
        int len = 0;
        int temp = x;
        while(temp>0) {
            temp = temp/10;
            len++;
        }
        int i=len-1;
        int leftTemp = x, rightTemp = x;
        while (i>=len/2) {
            int leftDigit = leftTemp/(int)(Math.pow((double) 10, i));
            leftTemp = leftTemp%(int)(Math.pow((double) 10, i));
            int rightDigit = rightTemp%10;
            rightTemp = rightTemp/10;
            if (leftDigit != rightDigit) return false;
            i--;
        }
        return true;
    }

    // Great solution
    // https://discuss.leetcode.com/topic/8090/9-line-accepted-java-code-without-the-need-of-handling-overflow
    // https://discuss.leetcode.com/topic/12820/an-easy-c-8-lines-code-only-reversing-till-half-and-then-compare
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0; // contains second half
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10; // remains with the first half
        }
        return (x==rev || x==rev/10);
    }
}
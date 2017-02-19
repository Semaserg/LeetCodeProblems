package LeetCode.dynamic.CountingBits_338;

/**
 https://leetcode.com/problems/counting-bits/?tab=Description

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear
time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
public class Solution {

    // HOw to calc the 1`s in int
    // Time complexity O(n)
    // https://discuss.leetcode.com/topic/40162/three-line-java-solution
    // https://discuss.leetcode.com/topic/41785/simple-java-o-n-solution-using-two-pointers
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if (num == 0) return result;
        result[1] = 1;
        if (num == 1) return result;

        int currentPowOfTwo = 2;
        while (currentPowOfTwo <= num) {
            int nextPowOfTwo = currentPowOfTwo;
            for (int i=0; i<currentPowOfTwo; i++) {
                if (currentPowOfTwo + i > num) break;
                result[currentPowOfTwo + i] = 1 + result[i];
                nextPowOfTwo++;
            }
            currentPowOfTwo = nextPowOfTwo;
        }
        return result;
    }

    // Time complexity O(n * size(int)) - size(int) == 32, 16 ...
    // http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
    public int[] countBits1(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if (num == 0) return result;
        for (int i=0; i<=num; i++) {
            int temp = i, cnt = 0;
            while (temp > 0) {
                cnt += temp & 1;
                temp >>= 1;
            }
            result[i] = cnt;
        }
        return result;
    }
}
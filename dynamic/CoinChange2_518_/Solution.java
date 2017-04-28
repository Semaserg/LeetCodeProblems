package LeetCode.dynamic.CoinChange2_518_;

/*
https://leetcode.com/problems/coin-change-2/#/description
518. Coin Change 2

You are given coins of different denominations and a total
amount of money. Write a function to compute the number of
combinations that make up that amount. You may assume that
you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
*/
public class Solution {
    int result = 0;

    // Time Limit exceeded, complexity O(n^n)
    public int change1(int amount, int[] coins) {
        if (amount == 0) return 1;
        result = 0;
        backTrack(amount, 0, coins);
        return result;
    }

    void backTrack(int amount, int index, int[] coins) {
        if (amount < 0 || index == coins.length) return;
        if (amount == 0) {
            result++;
            return;
        }
        for (int i=index; i<coins.length; i++) {
            backTrack(amount-coins[i], i, coins);
        }
    }

    // Complexity - time O(m*n), space O(m), m - amount, n - coins.length
    // https://discuss.leetcode.com/topic/79071/knapsack-problem-java-solution-with-thinking-process-o-nm-time-and-o-m-space
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount+1];
        memo[0] = 1;
        for(int coin : coins) {
            for(int currAmount=coin; currAmount<=amount; currAmount++) {
                int prevAmount = currAmount-coin;
                memo[currAmount] += memo[prevAmount];
            }
        }
        return memo[amount];
    }
}
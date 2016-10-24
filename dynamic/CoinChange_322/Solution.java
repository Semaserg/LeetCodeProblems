package LeetCode.dynamic.CoinChange_322;


import java.util.ArrayList;
import java.util.Arrays;

/*
322. Coin Change
https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total
amount of money amount. Write a function to compute the fewest
number of coins that you need to make up that amount. If that
amount of money cannot be made up by any combination of the
coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/
public class Solution {
    // Same idea
    // https://discuss.leetcode.com/topic/32475/c-o-n-amount-time-o-amount-space-dp-solution
    // Time complexity O(coins.len * amount),space complexity O(amount)
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        if (amount < coins[0]) return -1;

        int[] dp = new int[amount + 1]; // array with num of coins for each amount from 1 to amount.
        Arrays.fill(dp, -1); // set -1 by default

        // iterate for each amount from 1 to "amount" and find min num of coins for each.
        for (int am = 1; am <= amount; am++) {

            // iterate among the coins.
            for (int coin : coins) {
                if (am == coin) {
                    dp[am] = 1;
                    break;
                }
                int prev = am - coin; // prev amount
                if (prev > 0 && dp[prev] > 0) {
                    // dp[am] == -1 - if dp[am] not calculated before, just take dp[prev] + 1
                    // dp[prev] + 1 - means dp[prev] + one coin size of "coin".
                    dp[am] = (dp[am] == -1) ? dp[prev] + 1 : Math.min(dp[am], dp[prev] + 1);
                }
            }
        }
        return dp[amount];
    }
}
package LeetCode.array.BestTimeToBuyAndSellStock2_122;

/**
 122. Best Time to Buy and Sell Stock II
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

 Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 */
public class Solution {
    // looking for the local minimums and maximums
    public int maxProfit1(int[] prices) {
        int profit = 0;
        if (prices.length<2) return profit;
        if (prices.length==2) {
            profit = prices[1]-prices[0];
            if (profit > 0) return profit;
            else return 0;
        }
        int min = -1;
        for (int i=0; i<prices.length; i++) {
            //local minimum in the first day;
            if (i==0 && prices[i]<=prices[i+1]) min=prices[i];
            // local maximum in the last day;
            else if (i==prices.length-1 && prices[i]>=prices[i-1] && min != -1) {
                profit += prices[i]-min;
                min = 0;
            }
            // local minimum or maximum in the middle
            else if (i>0 && i<prices.length-1){
                if (prices[i]<=prices[i-1] && prices[i] <= prices[i+1]) {
                    min = prices[i];
                } else if (prices[i]>=prices[i-1] && prices[i] >= prices[i+1] && min != -1) {
                    profit += prices[i]-min;
                    min = -1;
                }
            }
        }
        return profit;
    }

    // simple every-day buy-sell solution
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length-1; i++) {
            profit += Math.max(prices[i+1]-prices[i], 0);
        }
        return profit;
    }
}
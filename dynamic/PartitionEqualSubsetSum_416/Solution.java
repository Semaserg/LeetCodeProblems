package LeetCode.dynamic.PartitionEqualSubsetSum_416;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
416. Partition Equal Subset Sum
https://leetcode.com/problems/partition-equal-subset-sum/description/

Given a non-empty array containing only positive integers, find if the array
can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/
class Solution {
    // https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
    public boolean canPartition(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("ex");
        int sum = 0;
        for(int i: nums) sum += i;
        if (sum%2 == 1) return false;

        // use 0/1 knapsack problem algorithm
        int ks = sum/2; //knapsackSize
        int ss = nums.length; // stuff list size
        //Arrays.sort(nums);
        int[][] dp = new int[ss][ks+1];
        // fill first col by zeros, not really necessary
        for (int i=0; i<ss; i++) {
            dp[i][0] = 0;
        }

        int[] weight = nums;
        for (int i=0; i<ss; i++) {
            for (int j=1; j<ks+1; j++) { // size of knapsack
                if (j < weight[i]) { // curr stuff is to big for the knapsack
                    if (i>0) dp[i][j] = dp[i-1][j]; // do not put current stuff to the knapsack, use prev set of items
                } else {
                    int prevKS = (i > 0) ? dp[i-1][j- weight[i]] : 0;
                    int includingCurr = weight[i] + prevKS;
                    int excludingCurr = (i > 0) ? dp[i-1][j] : 0;
                    dp[i][j] = Math.max(includingCurr, excludingCurr);
                }
            }
        }
        return dp[ss-1][ks] == ks;
    }
}
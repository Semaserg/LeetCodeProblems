package LeetCode.dynamic.UniqueBinarySearchTrees_96;

/*
96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/

Given n, how many structurally unique BST's
(binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    // Good explanation
    // https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
    // https://discuss.leetcode.com/topic/37310/fantastic-clean-java-dp-solution-with-detail-explaination
    // Time complexity O(n^2), space complexity O(n).
    public int numTrees(int n) {
        // dp - num of unique trees for 0, 1 ... n items in the tree.
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }
//
//    public int numTrees(int n) {
//        return numTreesRecursive(1, n);
//    }
//
//    private int numTreesRecursive(int min, int max) {
//        if (min == max) return 1;
//        int sum = 0;
//        for (int i=min; i<=max; i++) {
//            int left = (i > min) ? numTreesRecursive(min, i-1) : 0;
//            int right = (i < max) ? numTreesRecursive(i+1, max) : 0;
//            sum += left * right;
//        }
//        return sum;
//    }
}

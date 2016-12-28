package LeetCode.tree.BinaryTreeLongestConsecutiveSequence_298;

/**
 298. Binary Tree Longest Consecutive Sequence
 https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

 Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any
 node in the tree along the parent-child connections. The longest consecutive
 path need to be from parent to child (cannot be the reverse).

 For example,
 1
 \
 3
 / \
 2   4
 \
 5
 Longest consecutive sequence path is 3-4-5, so return 3.
 2
 \
 3
 /
 2
 /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    int dfs(TreeNode current, TreeNode parent, int prevLength) {
        if (current == null) return 0;
        int currLen = (parent != null && parent.val == current.val-1) ? prevLength+1 : 1;
        int leftLen = dfs(current.left, current, currLen);
        int rightLen = dfs(current.right, current, currLen);
        return Math.max(currLen, Math.max(leftLen, rightLen));
    }
}
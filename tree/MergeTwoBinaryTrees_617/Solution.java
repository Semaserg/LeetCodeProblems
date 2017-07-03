package LeetCode.tree.MergeTwoBinaryTrees_617;

/**
 617. Merge Two Binary Trees
 https://leetcode.com/problems/merge-two-binary-trees/#/description

 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees
 are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 then sum node values up as the new value of the merged node. Otherwise, the NOT null node
 will be used as the node of new tree.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode current = new TreeNode(t1.val + t2.val);
        current.left = mergeTrees(t1.left, t2.left);
        current.right = mergeTrees(t1.right, t2.right);
        return current;
    }
}
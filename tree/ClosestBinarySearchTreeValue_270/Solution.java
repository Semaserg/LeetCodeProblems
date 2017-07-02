package LeetCode.tree.ClosestBinarySearchTreeValue_270;


/**
 270. Closest Binary Search Tree Value
 https://leetcode.com/problems/closest-binary-search-tree-value/#/description

 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:
 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
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
// https://discuss.leetcode.com/topic/22590/4-7-lines-recursive-iterative-ruby-c-java-python
// https://discuss.leetcode.com/topic/25219/clean-and-concise-java-solution
public class Solution {
    Integer left = null;
    Integer right = null;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            if (left == null && right == null) return 0;
            if (left == null) return right;
            if (right == null) return left;
            return (Math.abs(left - target) < Math.abs(right - target)) ? left : right;
        }
        if (target < root.val) {
            right = root.val;
            return closestValue(root.left, target);
        } else {
            left = root.val;
            return closestValue(root.right, target);
        }
    }

    public int closestValue1(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }
            root = (target < root.val) ? root.left : root.right;
        }
        return ret;
    }
}
package LeetCode.tree.SumRootToLeafNumbers_129;

/**
 129. Sum Root to Leaf Numbers
 https://leetcode.com/problems/sum-root-to-leaf-numbers/

 Given a binary tree containing digits from 0-9 only,
 each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
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
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumRecursive(root, 0);
        return sum;
    }

    // Time complexity O(n), Space complexity O(h) - where h is tree height.
    private void sumRecursive(TreeNode root, int current) {
        current = current*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += current;
            return;
        }
        if (root.left != null) sumRecursive(root.left, current);
        if (root.right != null) sumRecursive(root.right, current);
    }
}
package LeetCode.tree.BinaryTreeUpsideDown_156_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 156. Binary Tree Upside Down
 https://leetcode.com/problems/binary-tree-upside-down/#/description

 Given a binary tree where all the right nodes are either leaf nodes
 with a sibling (a left node that shares the same parent node) or empty,
 flip it upside down and turn it into a tree where the original right
 nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
 / \
 3   1
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
    TreeNode newRoot;

    // time O(n), Space O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode last = dp(root);
        last.left = null;
        last.right = null;
        return newRoot;
    }

    private TreeNode dp(TreeNode current) {
        if (current.left == null) {
            newRoot = current;
            return current;
        }
        TreeNode prev = dp(current.left);
        prev.right = current;
        prev.left = current.right;
        return current;
    }
}
package LeetCode.tree.InorderSuccessorInBST_285_;

/**
 285. Inorder Successor in BST
 https://leetcode.com/problems/inorder-successor-in-bst/#/description

 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.

 http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/
 What is Inorder Suc­ces­sor: Inorder suc­ces­sor of a node is the next node in the inorder tra­ver­sal
 of the tree. For the last node in a tree, inorder suc­ces­sor will be NULL
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null) {
            if (root == p) return root.right;
            if (p.val < root.val) root = root.left;
            else root = root.right;
        }
        return null;
    }
}
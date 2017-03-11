package LeetCode.tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?tab=Description
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        int inordLeftInd = 0;
        int inordRightInd = inorder.length - 1;
        int preordRootInd = 0;
        TreeNode root = build(preorder, inorder, inordLeftInd, inordRightInd, preordRootInd);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int inordLeftInd, int inordRightInd, int preordRootInd) {
        if (inordLeftInd < 0 || inordRightInd >= inorder.length || inordLeftInd > inordRightInd) return null;
        int rootValue = preorder[preordRootInd];
        int inordRootInd = findIndex(inorder, inordLeftInd, inordRightInd, rootValue);
        int leftTreeLength = inordRootInd - inordLeftInd;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, inorder, inordLeftInd, inordRootInd-1, preordRootInd+1);
        root.right = build(preorder, inorder, inordRootInd+1, inordRightInd, preordRootInd+leftTreeLength+1);
        return root;
    }

    private int findIndex(int[] inorder, int inordLeftInd, int inordRightInd, int value) {
        for(int i = inordLeftInd; i<=inordRightInd; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}
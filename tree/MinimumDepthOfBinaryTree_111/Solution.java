package LeetCode.tree.MinimumDepthOfBinaryTree_111;

/**
 111. Minimum Depth of Binary Tree
 https://leetcode.com/problems/minimum-depth-of-binary-tree/

 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path
 from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // https://discuss.leetcode.com/topic/8723/my-4-line-java-solution
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth1(root.left);
        int r = minDepth1(root.right);
        // (l==0 || r==0) - if node has 0 or 1 child - return child depth+1;
        // !(l==0 || r==0) - node has two children, return min from them +1.
        return (l==0 || r==0) ? l+r+1 : Math.min(l,r) + 1;
    }
}
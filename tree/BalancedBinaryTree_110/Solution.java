package LeetCode.tree.BalancedBinaryTree_110;

/**
 110. Balanced Binary Tree
 https://leetcode.com/problems/balanced-binary-tree/

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined
 as a binary tree in which the depth of the two subtrees of
 every node never differ by more than 1.
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
// Good description
// https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
public class Solution {
    private boolean isBal = true;

    public boolean isBalanced(TreeNode root) {
        checkDepth(root);
        return isBal;
    }

    private int checkDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = checkDepth(root.left);
        int lr = checkDepth(root.right);
        if (Math.abs(lh - lr)>1) isBal = false;
        return Math.max(lh, lr) + 1;
    }
    // Good solution from here
    // https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
    /*class solution {
        public:
        int dfsHeight (TreeNode *root) {
            if (root == NULL) return 0;

            int leftHeight = dfsHeight (root -> left);
            if (leftHeight == -1) return -1;
            int rightHeight = dfsHeight (root -> right);
            if (rightHeight == -1) return -1;

            if (abs(leftHeight - rightHeight) > 1)  return -1;
            return max (leftHeight, rightHeight) + 1;
        }
        bool isBalanced(TreeNode *root) {
            return dfsHeight (root) != -1;
        }
    };*/
}
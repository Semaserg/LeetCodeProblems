package LeetCode.tree.SymmetricTree_101;

/**
 101. Symmetric Tree
 https://leetcode.com/problems/symmetric-tree/

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */

import java.util.LinkedList;
import java.util.Queue;

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

    // Recursive solution
    // Time complexity O(n), space complexity O(n) - because of recursion.
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    // using pre-order tree traversal.
    private boolean compare(TreeNode leftRoot, TreeNode rightRoot) {
        // Good shortcut
        //if(left==null || right==null) return left==right;
        if (leftRoot == null && rightRoot == null) return true;
        if (leftRoot == null || rightRoot == null) return false;
        if (leftRoot.val != rightRoot.val) return false;
        boolean isOutersEqual = compare(leftRoot.left, rightRoot.right);
        boolean isInnersEqual = compare(leftRoot.right, rightRoot.left);
        return isOutersEqual && isInnersEqual;
    }

    // Iterative solution, Time complexity - O(n), space complexity - O(n).
    // https://discuss.leetcode.com/topic/16889/short-and-clean-java-iterative-solution/2 - same solution using one Queue.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> ql = new LinkedList<>();
        Queue<TreeNode> qr = new LinkedList<>();
        ql.add(root.left);
        qr.add(root.right);
        while (!ql.isEmpty() && !qr.isEmpty()) {
            TreeNode l = ql.remove();
            TreeNode r = qr.remove();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            ql.add(l.left);
            ql.add(l.right);
            qr.add(r.right);
            qr.add(r.left);
        }
        return true;
    }
}
package LeetCode.tree.ValidateBinarySearchTree_98;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 98. Validate Binary Search Tree
 https://leetcode.com/problems/validate-binary-search-tree/

 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
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

// https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
public class Solution {

    // My stupid solution - working fine
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        return isValid(root.left, null, root.val) && isValid(root.right, root.val, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        boolean greaterThanMin = (min == null) ? true : (root.val > min);
        boolean lesserThanMax = (max == null) ? true : (root.val < max);
        if (greaterThanMin && lesserThanMax) {
            int leftMax = (max == null) ? root.val : Math.min(max, root.val);
            boolean isLeftValid = isValid(root.left, min, leftMax );

            int rightMin = (min == null) ? root.val : Math.max(root.val, min);
            boolean isRightValid = isValid(root.right, rightMin, max );
            return isLeftValid && isRightValid;
        }
        return false;
    }

    // https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
    // https://en.wikipedia.org/wiki/Binary_search_tree - tree validation
    // The main idea is node value should be  min<val<max, how to get min and max?
    // for left node - min = parent.min, max = parent.value
    // for right node - min = parent.value, max = parent.max
    public boolean isValidBST2(TreeNode root) {
        return isValidRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidRecursive(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (min < root.val && root.val < max) {
            return isValidRecursive(root.left, min, root.val) && isValidRecursive(root.right, root.val, max);
        }
        return false;
    }

    // Iterative solution
    // https://discuss.leetcode.com/topic/46016/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution
    // Recursive solution
    // https://discuss.leetcode.com/topic/4659/c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more
    // Main idea is next: we can traverse tree from the min element to max.
    // The most left leaf - is min, the most right leaf - is max.
    // In each iteration we check that current<prev. For the min el - prev is null.
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // go to the most left el
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            root = curr.right;
        }
        return true;
    }
}

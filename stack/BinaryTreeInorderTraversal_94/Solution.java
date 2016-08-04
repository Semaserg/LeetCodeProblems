package LeetCode.stack.BinaryTreeInorderTraversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?

Explanation
http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
*/

public class Solution {

    // Time complexity O(n) - one node is visited once, space complexity O(n) - result array + tree = 2n => n.
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        recursiveTraversal(root, result);
        return result;
    }

    private void recursiveTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        recursiveTraversal(root.left, result);
        result.add(root.val);
        recursiveTraversal(root.right, result);
    }

    // Time complexity O(n) - one node can be visited twice => 2n => n
    // space complexity O(n) - result array + tree = 2n => n.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
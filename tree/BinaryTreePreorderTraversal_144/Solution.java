package LeetCode.tree.BinaryTreePreorderTraversal_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 144. Binary Tree Preorder Traversal
 https://leetcode.com/problems/binary-tree-preorder-traversal/

 Given a complete binary tree, count the number of nodes.
 Given a binary tree, return the preorder traversal of its nodes' values.
 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
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
    // http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html - inorder traversal solution
    // https://discuss.leetcode.com/topic/6493/accepted-iterative-solution-in-java-using-stack - store only rights.
    // Time complexity O(n), space complexity O(n).
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null) {
            while (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            TreeNode right = null;
            while (right == null && !stack.empty()) {
                right = stack.pop().right;
            }
            current = right;
        }
        return result;
    }

    //http://www.geeksforgeeks.org/iterative-preorder-traversal/
    /*
    1) Create an empty stack nodeStack and push root node to stack.
    2) Do following while nodeStack is not empty.
    ….a) Pop an item from stack and print it.
    ….b) Push right child of popped item to stack
    ….c) Push left child of popped item to stack

    Right child is pushed before left child to make sure that left subtree is processed first.
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
package LeetCode.tree.BinaryTreeRightSideView_199;

import java.util.*;

/**
 199. Binary Tree Right Side View
 https://leetcode.com/problems/binary-tree-right-side-view/

 Given a binary tree, imagine yourself standing on the right side of it,
 return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
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
    // Breadth first solution
    // Time complexity O(n), space complexity O(n) - worst case, in case of flatt tree (linked list).
    // https://discuss.leetcode.com/topic/11315/reverse-level-order-traversal-java
    // recursive solution
    // https://discuss.leetcode.com/topic/11768/my-simple-accepted-solution-java
    // main idea of recursive solution: process right node before left, get only one node from the level,
    // thus it should be the most right element.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // get level size before add next level.
            int size = q.size();
            // do peer just to keep analyzer happy.
            TreeNode node = q.peek();
            for (int i=0; i<size; i++) {
                node = q.remove();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // node - is the last node in the level
            result.add(node.val);
        }
        return result;
    }
}
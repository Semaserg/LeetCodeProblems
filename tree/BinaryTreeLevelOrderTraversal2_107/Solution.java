package LeetCode.tree.BinaryTreeLevelOrderTraversal2_107;

import java.util.*;
/**
 107. Binary Tree Level Order Traversal II
 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
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
    // Queue solution, time complexity O(n), space complexity O(n), n - number of nodes.
    // https://discuss.leetcode.com/topic/28537/java-solution-using-queue
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levelSize = q.size();
            // extract whole level from queue, and push next level.
            for(int i=0; i<levelSize; i++) {
                TreeNode current = q.remove();
                list.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            result.add(0, list);
        }
        return result;
    }

    // Recursive solution
    // https://discuss.leetcode.com/topic/1672/is-there-any-better-idea-than-doing-regular-level-order-traversal-and-reverse-the-result
    // Time and space complexity O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelOrderBottomRecursive(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private void levelOrderBottomRecursive(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(level, list);
        } else {
            result.get(level).add(root.val);
        }
        int nextLevel = ++level;
        if (root.left != null) levelOrderBottomRecursive(root.left, nextLevel, result);
        if (root.right != null) levelOrderBottomRecursive(root.right, nextLevel, result);
    }
}

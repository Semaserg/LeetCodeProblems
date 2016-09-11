package LeetCode.tree.BinaryTreeZigzagLevelOrderTraversal_103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 103. Binary Tree Zigzag Level Order Traversal
 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
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
    // Great DFS solution
    // https://discuss.leetcode.com/topic/3413/my-accepted-java-solution

    // https://en.wikipedia.org/wiki/Binary_tree
    // Tine complexity O(n), space complexity O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i=0; i<levelSize; i++) {
                TreeNode tn = q.poll();
                if (leftToRight) level.add(tn.val);
                else level.add(0, tn.val);
                // by the way, we could switch the direction to swap next to lines for each level:
                // 1: right and then left, 2: left then right.
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
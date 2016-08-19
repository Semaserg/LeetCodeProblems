package LeetCode.tree.BinaryTreeLevelOrderTraversal_102;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 102. Binary Tree Level Order Traversal
 https://leetcode.com/problems/binary-tree-level-order-traversal/

 Given a binary tree, return the level order traversal of its
 nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
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
// https://discuss.leetcode.com/topic/10469/c-solution-using-only-one-queue-use-a-marker-null - using NULL marker in the queue
public class Solution {

    // Breadth-first solution
    // Time complexity O(n), space complexity hard to say, depending on max number of items in the queue.
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode current = q.remove();
                list.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            result.add(list);
        }
        return result;
    }

    // Depth-first solution
    // https://discuss.leetcode.com/topic/7332/java-solution-using-dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelOrderRecursive(result, root, 0);
        return result;
    }

    private void levelOrderRecursive(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        if (height >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(height).add(root.val);
        levelOrderRecursive(result, root.left, height+1);
        levelOrderRecursive(result, root.right, height+1);
    }
}
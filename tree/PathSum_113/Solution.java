package LeetCode.tree.PathSum_113;

/**
 113. Path Sum II
 https://leetcode.com/problems/path-sum-ii/

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        pathSumRecursive(res, path, root, sum);
        return res;
    }

    private void pathSumRecursive(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        // if root is leaf.
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(getExtCopy(path, root.val));
            } else {
                return;
            }
        }
        if (root.left != null) {
            pathSumRecursive(res, getExtCopy(path, root.val), root.left, sum-root.val);
        }
        if (root.right != null) {
            pathSumRecursive(res, getExtCopy(path, root.val), root.right, sum-root.val);
        }
    }

    private List<Integer> getExtCopy(List<Integer> path, int value) {
        List<Integer> current = new ArrayList<>(path);
        current.add(value);
        return current;
    }
}
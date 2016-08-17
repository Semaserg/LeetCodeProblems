package LeetCode.tree.BinaryTreePaths_257;

import java.util.*;
/**
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

   1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        binaryTreePathsRecursive(root, "", result);
        return result;
    }

    private void binaryTreePathsRecursive(TreeNode root, String path, List<String> result) {
        path += path.isEmpty() ? root.val : "->" + root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) binaryTreePathsRecursive(root.left, path, result);
        if (root.right != null) binaryTreePathsRecursive(root.right, path, result);
    }
}
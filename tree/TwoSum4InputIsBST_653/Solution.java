package LeetCode.tree.TwoSum4InputIsBST_653;

/**
 653. Two Sum IV - Input is a BST
 Given a Binary Search Tree and a target number, return true if there exist two elements in the BST
 such that their sum is equal to the given target.

 Example 1:

 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTargetRecursive(root, new HashSet<>(), k);
    }

    boolean findTargetRecursive(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(k - root.val);
        return findTargetRecursive(root.left, set, k) || findTargetRecursive(root.right, set, k);
    }
}
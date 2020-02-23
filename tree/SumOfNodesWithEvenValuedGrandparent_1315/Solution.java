package LeetCode.tree.SumOfNodesWithEvenValuedGrandparent_1315;

/**
 1315. Sum of Nodes with Even-Valued Grandparent
 https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

 Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 (A grandparent of a node is the parent of its parent, if it exists.)

 If there are no nodes with an even-valued grandparent, return 0.
 */

import java.util.LinkedList;
import java.util.Queue;

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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.val%2 == 0) {
            if (root.left != null) {
                sum += (root.left.left != null) ? root.left.left.val : 0;
                sum += (root.left.right != null) ? root.left.right.val : 0;
            }
            if (root.right != null) {
                sum += (root.right.left != null) ? root.right.left.val : 0;
                sum += (root.right.right != null) ? root.right.right.val : 0;
            }
        }
        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
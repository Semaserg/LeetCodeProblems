package LeetCode.tree.FlattenBinaryTreeToLinkedList_114;

/**
 114. Flatten Binary Tree to Linked List
 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 Hints:
 If you notice carefully in the flattened tree, each node's right child
 points to the next node of a pre-order traversal.
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
    // not recursive solution
    // the idea is next:
    // 1. get current node, if it has left - take it, and go right branches.
    // 2. insert this left branch between root and it`s right child.
    // 3. move to the next right node.
    // https://discuss.leetcode.com/topic/3995/share-my-simple-non-recursive-solution-o-1-space-complexity
    // Time complexity - O(n), space complexity O(1).
    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode leftBranch = curr.left;
                while (leftBranch.right != null) {
                    leftBranch = leftBranch.right;
                }
                leftBranch.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // next item in linked list. From the beginning it`s null - the end of the list.
    // than it`s the tail of the linked list and so on till the head.
    private TreeNode next;

    // Time complexity O(n), space complexity O(n) - because of stack.
    // recursive solution, post-order tree traversal approach.
    // https://discuss.leetcode.com/topic/11444/my-short-post-order-traversal-java-solution-for-share
    // for instance we have a tree
    //      5
    //    /   \
    //   4     6
    //  / \
    // 2   3
    // node would be visited in next order: 6, 3, 2, 4, 5.
    // very important to call "flatten" of the right node and then of the left one.
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        System.out.print("NEXT=" + ((next != null) ? next.val : "null") + "; ");
        System.out.print("ROOT=" + ((root != null) ? root.val : "null") + "; ");
        System.out.println("RIGHT=" + ((root.right != null) ? root.right.val : "null") + "; ");
        // start visiting the node from this point.
        root.right = next;
        root.left = null;
        next = root;
    }
}
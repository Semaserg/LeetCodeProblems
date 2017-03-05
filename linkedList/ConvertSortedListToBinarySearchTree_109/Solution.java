package LeetCode.linkedList.ConvertSortedListToBinarySearchTree_109;

/*
109. Convert Sorted List to Binary Search Tree
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Given a singly linked list where elements are sorted
in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
// Time complexity O(n), space complexity O(log n) because of recursion stack
// http://articles.leetcode.com/convert-sorted-list-to-balance  d-binary
// https://discuss.leetcode.com/topic/3286/share-my-code-with-o-n-time-and-o-1-space
// https://discuss.leetcode.com/topic/8141/share-my-o-1-space-and-o-n-time-java-code
public class Solution {
    private ListNode currentNode;

    private int size(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private TreeNode buildTree(int treeSize) {
        if (treeSize == 0) return null;
        TreeNode tn = new TreeNode(0);
        tn.left = buildTree(treeSize/2);
        tn.val = currentNode.val;
        currentNode = currentNode.next;
        tn.right = buildTree(treeSize - treeSize/2 -1);
        return tn;
    }

    public TreeNode sortedListToBST(ListNode head) {
        currentNode = head;
        return buildTree(size(head));
    }
}
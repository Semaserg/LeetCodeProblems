package LeetCode.tree.ConvertSortedArrayToBinarySearchTree_108;

/**
 108. Convert Sorted Array to Binary Search Tree
 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convert(nums, 0, nums.length-1);
    }

    private TreeNode convert(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (left < mid) root.left = convert(nums, left, mid-1);
        if (right > mid) root.right = convert(nums, mid+1, right);
        return root;
    }
}
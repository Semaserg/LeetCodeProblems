package LeetCode.dynamic.UniqueBinarySearchTrees2_95;

/*
95. Unique Binary Search Trees II
https://leetcode.com/problems/unique-binary-search-trees-ii/

Given an integer n, generate all structurally unique BST's
(binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return gen1(1, n);
    }

    /*this algorithm has next idea:
    for instance n=3, we call gen(1,3).
    it means we should select 1 as a root, and build all possible trees from the rest of sequence - [2,3] (call it sequence A)
    And make "for" loop each time creating new TreeNode(1) and connecting it with every tree from generated before.

    Sequence A is divided into two parts by selected root. For instance if root = 2, we have [1] and [3].
    This two sub-sequences we should use to build set of possible left sub-trees and right subtrees.
    if left sub-trees array is empty - use only right ones, and vs.
    if left sub-trees and right sub-trees are not empty - we should generate a composition of all possible variants.
    */
    // https://discuss.leetcode.com/topic/3079/a-simple-recursive-solution
    // Time complexity - ???
    private List<TreeNode> gen(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start == end) {
            result.add(new TreeNode(start));
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = (i > start) ? gen(start, i-1) : new LinkedList<>();
            List<TreeNode> rights = (i < end) ? gen(i+1, end) : new LinkedList<>();

            // if (lefts.size() == 0 && rights.size() == 0) <- covered by if (start == end)
            if (lefts.size() == 0) {
                for (TreeNode r : rights) {
                    TreeNode curr = new TreeNode(i);
                    curr.right = r;
                    result.add(curr);
                }
            }
            else if (rights.size() == 0) {
                for (TreeNode l : lefts) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    result.add(curr);
                }
            }
            else {
                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = l;
                        curr.right = r;
                        result.add(curr);
                    }
                }
            }
        }
        return result;
    }

    // https://discuss.leetcode.com/topic/3079/a-simple-recursive-solution/15
    private List<TreeNode> gen1(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = gen1(start, i-1);
            List<TreeNode> rights = gen1(i+1, end);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }
        return result;
    }
}
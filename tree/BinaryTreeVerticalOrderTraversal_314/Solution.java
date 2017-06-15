package LeetCode.tree.BinaryTreeVerticalOrderTraversal_314;

import java.util.*;

/**
 314. Binary Tree Vertical Order Traversal
 https://leetcode.com/problems/binary-tree-vertical-order-traversal/#/description

 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.
 */
public class Solution {
    private int min = 0;
    private int max = 0;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> levels = new LinkedList<>();
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int level = levels.poll();

            add(level, current.val);
            if (current.left != null) {
                queue.add(current.left);
                levels.add(level-1);
            }
            if (current.right != null) {
                queue.add(current.right);
                levels.add(level+1);
            }
        }

        return convertMapToList();
    }


    public List<List<Integer>> verticalOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(0, root);
        return convertMapToList();
    }

    // dfs gives wrong result needed bfs
    private void dfs(int level, TreeNode current) {
        if (current == null) return;
        add(level, current.val);
        dfs(level-1, current.left);
        dfs(level+1, current.right);
    }

    private void add(int level, int value) {
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
            max = Math.max(max, level);
            min = Math.min(min, level);
        }
        map.get(level).add(value);
    }

    private List<List<Integer>> convertMapToList() {
        List<List<Integer>> result = new LinkedList<>();
        for (int i= min; i<=max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
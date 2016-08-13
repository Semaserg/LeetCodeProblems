package LeetCode.tree.CountCompleteTreeNodes_222;

/**
 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far
 left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees
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
    // Good solutions
    // https://discuss.leetcode.com/topic/18508/accepted-clean-java-solution/2 - good description.
    // https://discuss.leetcode.com/topic/49942/beating-99-84-submissions-in-c-quite-intuitive-and-well-commented/2 - second one.
    // https://discuss.leetcode.com/topic/21317/accepted-easy-understand-java-solution\
    // Time complexity O(log n), space complexity O(1)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // as we use left nodes in both the trees to calc the height,
        // if leftHeight == rightHeight - it means that left tree if complete tree, but right is almost complete tree.
        // so we should get root + left tree size (complete tree) + calcSize (right tree - almost complete tree)
        // in other case right tree is still almost completed, but all the leaves have the save depth =>
        // right tree size = 2^right tree depth - 1;
        // result = 1 + right tree size + calc left tree size;
        int leftTreeSize = 0;
        int rightTreeSize = 0;
        if (leftHeight == rightHeight) {
            // 1 << leftHeight == 2^leftHeight
            leftTreeSize = (1 << leftHeight) - 1;
            rightTreeSize = countNodes(root.right);
        } else {
            leftTreeSize = countNodes(root.left);
            rightTreeSize = (1 << rightHeight) - 1;
        }
        return 1 + leftTreeSize + rightTreeSize;
    }

    /**
     * Go to bottom of the tree by left side.
     * So right side can be smaller.
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}
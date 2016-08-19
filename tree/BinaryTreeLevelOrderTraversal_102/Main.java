package LeetCode.tree.BinaryTreeLevelOrderTraversal_102;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);

        List<List<Integer>> result = s.levelOrder(root);
        System.out.print(result);
    }
}

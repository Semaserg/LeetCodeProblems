package LeetCode.tree.BinaryTreeUpsideDown_156_;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        TreeNode result = s.upsideDownBinaryTree(root);
        System.out.println(result);
    }
}

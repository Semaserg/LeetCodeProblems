package LeetCode.stack.BinaryTreeInorderTraversal_94;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution s = new Solution();
        List<Integer> result = s.inorderTraversal(root);
        System.out.print(result);
    }
}



package LeetCode.tree.BinaryTreeVerticalOrderTraversal_314;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        List<List<Integer>> result = s.verticalOrder(root);
        for (List l : result) {
            System.out.println(l);
        }
    }
}

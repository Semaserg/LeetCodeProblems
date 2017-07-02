package LeetCode.tree.ClosestBinarySearchTreeValue_270;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(15);

        int result = s.closestValue(root, 11.5);
        System.out.println(result);
    }
}

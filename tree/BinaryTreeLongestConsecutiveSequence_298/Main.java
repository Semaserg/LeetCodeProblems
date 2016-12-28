package LeetCode.tree.BinaryTreeLongestConsecutiveSequence_298;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        int result = s.longestConsecutive(root);
        System.out.print(result);
    }
}

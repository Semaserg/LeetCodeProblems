package LeetCode.tree.CountCompleteTreeNodes_222;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        int count = s.countNodes(root);
        System.out.print(count);
    }
}

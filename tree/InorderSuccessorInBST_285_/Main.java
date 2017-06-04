package LeetCode.tree.InorderSuccessorInBST_285_;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        TreeNode t = s.inorderSuccessor(root, root);
        System.out.print(t);
    }
}

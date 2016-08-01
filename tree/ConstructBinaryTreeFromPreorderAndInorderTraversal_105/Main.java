package LeetCode.tree.ConstructBinaryTreeFromPreorderAndInorderTraversal_105;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {2,5,1,3,6,4};
        int[] preorder = {1,5,3,2,6,4};
        TreeNode root = s.buildTree(inorder, preorder);
        System.out.print(root);
    }
}

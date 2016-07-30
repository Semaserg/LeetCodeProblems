package LeetCode.tree.ConstructBinaryTreeFromInorderAndPostorderTraversal_106;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {3,2,1};
        int[] postorder = {3,2,1};
        TreeNode root = s.buildTree(inorder, postorder);
        System.out.print(root);
    }
}



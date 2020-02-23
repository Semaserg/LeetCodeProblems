package LeetCode.tree.SumOfNodesWithEvenValuedGrandparent_1315;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        int res = s.sumEvenGrandparent(root);
        System.out.print(res);
    }
}

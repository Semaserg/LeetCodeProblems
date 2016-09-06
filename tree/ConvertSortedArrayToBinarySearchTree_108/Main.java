package LeetCode.tree.ConvertSortedArrayToBinarySearchTree_108;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.sortedArrayToBST(new int[]{1,2,3,4,5});
        System.out.print(root);
    }
}

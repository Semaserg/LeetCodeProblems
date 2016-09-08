package LeetCode.dynamic.UniqueBinarySearchTrees2_95;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution n = new Solution();
        List<TreeNode> result = n.generateTrees(3);
        for (TreeNode root : result) {
            System.out.println(root);
        }
    }
}



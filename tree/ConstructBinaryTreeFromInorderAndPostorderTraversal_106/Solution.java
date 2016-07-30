package LeetCode.tree.ConstructBinaryTreeFromInorderAndPostorderTraversal_106;

/**
 106. Construct Binary Tree from Inorder and Postorder Traversal
 https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Good solutions
// https://discuss.leetcode.com/topic/48054/my-java-recursive-answer-beat-92-9-2ms
// https://discuss.leetcode.com/topic/37225/20ms-java-easy-to-understand-recursive-solution
//
// Good explanation
// https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space
// The the basic idea is to take the last element in postorder array as the root,
// find the position of the root in the inorder array; then locate the range for left sub-tree and right sub-tree
// and do recursion. Use a HashMap to record the index of root in the inorder array.

// O(n*log n) time complexity, O(n) space complexity.
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || postorder.length != inorder.length) return null;
        int left = 0;
        int right = inorder.length-1;
        int postorderRoot = postorder.length-1;
        return buildTreeRecursive(inorder, postorder, left, right, postorderRoot);
    }

    private TreeNode buildTreeRecursive(int[] inorder, int[] postorder, int inorderLeftInd, int inorderRightInd,
                                        int postorderRootInd) {
        if (inorderLeftInd > inorderRightInd || inorderLeftInd<0 || inorderRightInd>=inorder.length) return null;

        // we need postorder array just to get the root value;
        int rootValue = postorder[postorderRootInd];

        // find index in inorder by value
        int rootInorderInd = findIndexByValue(inorder, inorderLeftInd, inorderRightInd, rootValue);

        TreeNode root = new TreeNode(rootValue);

        // left tree and right tree can have different size.
        int leftTreeSize = inorderRightInd - rootInorderInd;

        // last element of the left subtree. Then right subtree and root.
        int leftSubtreePostorderRootInd = postorderRootInd-leftTreeSize-1;
        root.left = buildTreeRecursive(inorder, postorder, inorderLeftInd, rootInorderInd-1, leftSubtreePostorderRootInd);

        // just before the current postorder root.
        int rightSubtreePostorderRootInd = postorderRootInd-1;
        root.right = buildTreeRecursive(inorder, postorder, rootInorderInd+1, inorderRightInd, rightSubtreePostorderRootInd);

        return root;
    }

    // Hashmap<value, index> can be used to make get operation in O(1) time.
    private int findIndexByValue(int[] inorder, int inorderLeftInd, int inorderRightInd, int value) {
        for(int i=inorderLeftInd; i<= inorderRightInd; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}

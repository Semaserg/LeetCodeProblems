package LeetCode.tree.LowestCommonAncestorOfABinaryTree_236;

/**
 236. Lowest Common Ancestor of a Binary Tree
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 between two nodes v and w as the lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 Another example is LCA of nodes 5 and 4 is 5, since a node can be a
 descendant of itself according to the LCA definition.
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
public class Solution {

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        findLca(root, p, q);
        return lca;
    }

    // Time complexity O(n), space complexity O(h) - because of stack (h - tree height) - worst case O(n) for linked list case.
    // http://stackoverflow.com/questions/9844193/what-is-the-time-and-space-complexity-of-a-breadth-first-and-depth-first-tree-tr
    public boolean findLca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean isCurrent = root == p || root == q;
        boolean foundInTheLeft = findLca(root.left, p, q);
        boolean foundInTheRight = findLca(root.right, p, q);
        boolean foundBoth = (isCurrent && foundInTheLeft) || (isCurrent && foundInTheRight ) || (foundInTheLeft && foundInTheRight);
        if (foundBoth && lca == null) {
            lca = root;
        }
        return isCurrent || foundInTheLeft || foundInTheRight;
    }

    // https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby
    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Could be a case if root has a children, and one of them is other node we are looking for.
        // It can be, can be not. Just propagate root to the top. So other branches return null,
        // and our root would be propagated till the top of recursion calls.
        // This approach is not good for the case if tree might not contains p or q.
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left == null) ? right : left;
    }
}
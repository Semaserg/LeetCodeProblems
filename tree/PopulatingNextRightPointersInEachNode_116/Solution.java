package LeetCode.tree.PopulatingNextRightPointersInEachNode_116;

/**
 116. Populating Next Right Pointers in Each Node
 https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

 iven a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    // https://discuss.leetcode.com/topic/6221/java-solution-with-o-1-memory-o-n-time
    // BFS solution
    // this solution is not eligible because we use Queue.
    // From the problem "You may only use constant extra space."
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode next = null;
            for (int i=0; i<size; i++) {
                TreeLinkNode curr = q.remove();
                curr.next = next;
                if (curr.right != null) q.add(curr.right);
                if (curr.left != null) q.add(curr.left);
                next = curr;
            }
        }
    }

    // recursive solution
    // https://discuss.leetcode.com/topic/12241/my-recursive-solution-java
    // not recursive solution
    // https://discuss.leetcode.com/topic/2202/a-simple-accepted-solution
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) { // if level exists
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
package LeetCode.dynamic.SerializeAndDeserializeBinaryTree_297;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://discuss.leetcode.com/topic/28029/easy-to-understand-java-solution
public class Codec {
    private static final String SEPARATOR = ",";
    private static final String NULLNODE = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULLNODE).append(SEPARATOR);
        } else {
            sb.append(root.val).append(SEPARATOR);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SEPARATOR)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String curr = queue.remove();
        if (curr.equals(NULLNODE)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
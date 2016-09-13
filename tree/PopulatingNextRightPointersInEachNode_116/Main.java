package LeetCode.tree.PopulatingNextRightPointersInEachNode_116;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.left = new TreeLinkNode(4);
        root.right.right = new TreeLinkNode(3);

        s.connect(root);
        System.out.print(root);
    }
}

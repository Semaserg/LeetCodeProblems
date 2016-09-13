package LeetCode.tree.PopulatingNextRightPointersInEachNode_116;

public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(int x) { val = x; }

    @Override
    public String toString() {
        if (this == null) return "NULL";
        String leftStr = this.left != null ? this.left.toString() : "NULL";
        String rightStr = this.right != null ? this.right.toString() : "NULL";
        String nextStr = this.next != null ? this.next.toString() : "NULL";
        return "ROOT: " + val + " LEFT: " + leftStr + " RIGHT: " + rightStr + " NEXT: " + nextStr;
    }
}

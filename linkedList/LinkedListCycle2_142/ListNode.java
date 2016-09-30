package LeetCode.linkedList.LinkedListCycle2_142;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val + "->");
            current = current.next;
        }
        return sb.toString();
    }
}

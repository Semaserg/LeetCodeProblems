package LeetCode.linkedList.RemoveLinkedListElements_203;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);

        a.next = b;
        b.next = c;

        Solution s = new Solution();
        ListNode result = s.removeElements(a,3);
        System.out.print(result);
    }
}

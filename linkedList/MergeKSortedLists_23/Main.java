package LeetCode.linkedList.MergeKSortedLists_23;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(10);
        a.next = b;
        b.next = c;

        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(11);
        a1.next = b1;
        b1.next = c1;

        ListNode a2 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        ListNode c2 = new ListNode(20);
        a2.next = b2;
        b2.next = c2;

        Solution s = new Solution();
        ListNode res = s.mergeKLists(new ListNode[]{a, a1, a2});
        System.out.print(res);
    }
}

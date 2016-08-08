package LeetCode.linkedList.MergeTwoSortedLists_21;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(4);

        // first list
        a.next = b;
        b.next = c;

        // second list
        d.next = e;
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(a,d);
        System.out.print(result);
    }
}

package LeetCode.linkedList.InsertionSortList_147;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);

        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;

        Solution s = new Solution();
        ListNode head = s.insertionSortList(a);
        System.out.print(head);
    }
}

package LeetCode.linkedList.ReverseLinkedList2_92;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution s = new Solution();
        ListNode res = s.reverseBetween(a,2,4);
        System.out.print(res);
    }
}

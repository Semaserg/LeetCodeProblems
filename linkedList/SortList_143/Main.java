package LeetCode.linkedList.SortList_143;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(2);
//        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;

        Solution s = new Solution();
        ListNode result = s.sortList(a);
        System.out.print(result);
    }
}

package LeetCode.linkedList.AddTwoNumbers_2;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;

        c.next = d;
        d.next = e;

        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(a, c);
        System.out.print(res);
    }
}

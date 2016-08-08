package LeetCode.linkedList.IntersectionOfTwoLinkedLists_160;

public class Main {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);

        // first list
        a1.next = a2;
        //a2.next = c1;

        // second list
        b1.next = b2;
        b2.next = b3;
        //b3.next = c1;

        // rest of the array
        c1.next = c2;
        c2.next = c3;

        Solution s = new Solution();
        ListNode result = s.getIntersectionNode(a1,b1);
        System.out.print(result);
    }
}

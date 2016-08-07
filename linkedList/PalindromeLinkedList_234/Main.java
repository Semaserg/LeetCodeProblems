package LeetCode.linkedList.PalindromeLinkedList_234;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Solution s = new Solution();
        boolean result = s.isPalindrome(a);
        System.out.print(result);
    }
}

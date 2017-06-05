package LeetCode.linkedList.ReverseLinkedList2_92;

/*
92. Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n.
Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
*/

// https://discuss.leetcode.com/topic/8976/simple-java-solution-with-clear-explanation
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        int cnt = 0;

        // find node before reverse sublist, and first node of reverse sublist
        ListNode curr = fakeHead;
        while (cnt < m-1) {
            curr = curr.next;
            cnt++;
        }

        ListNode beforeRev = curr;
        ListNode firstRev = curr.next;

        // reverse [m .. n] sublist
        cnt++;
        curr = curr.next;

        ListNode temp = curr; // first item in reverse sublist
        curr = curr.next; // second item in reverse sublist
        ListNode next;

        while (cnt < n) {
            next = curr.next;
            curr.next = temp;
            temp = curr;
            curr = next;
            cnt++;
        }

        beforeRev.next = temp;
        firstRev.next = curr;
        return fakeHead.next;
    }
}
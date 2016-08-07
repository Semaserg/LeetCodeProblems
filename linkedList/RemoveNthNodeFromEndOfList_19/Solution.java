package LeetCode.linkedList.RemoveNthNodeFromEndOfList_19;

/*
19. Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // two pointers solution with n-diff between pointers.
    // https://discuss.leetcode.com/topic/7753/c-solution-easy-to-understand-with-explanations/2
    // https://discuss.leetcode.com/topic/7031/simple-java-solution-in-one-pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // we need this for case when n=len => going to remove the head.
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode fast = fakeHead;
        ListNode slow = fakeHead;

        for (int i=0; i<n; i++) {
            fast = fast.next;
        }
        // we should stop fast at the last element, in such case slow will be the item before target.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow - item before target
        // slow.next - target
        // slow.next.next - just after target, is null if target ia the last item in the list.
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}

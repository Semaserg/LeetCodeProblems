package LeetCode.linkedList.RemoveLinkedListElements_203;

/*
203. Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    // Time complexity O(n)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode current = newHead;
        while (current != null) {
            ListNode nextItem = current.next;
            if(nextItem != null && nextItem.val == val) {
                current.next = nextItem.next;
            } else {
                current = current.next;
            }
        }
        return newHead.next;
    }
}

// recursive solution
// https://discuss.leetcode.com/topic/12580/3-line-recursive-solution
//public ListNode removeElements(ListNode head, int val) {
//    if (head == null) return null;
//    head.next = removeElements(head.next, val);
//    return head.val == val ? head.next : head;
//}

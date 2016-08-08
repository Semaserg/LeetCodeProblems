package LeetCode.linkedList.ReverseLinkedList_206;

/*
206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.
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
    // http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
    // Time complexity O(n), space complexity O(1)
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    // Great iterative and recursive solutions
    // https://discuss.leetcode.com/topic/13268/in-place-iterative-and-recursive-java-solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseListRecursive(null, head);
    }

    public ListNode reverseListRecursive(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode newPrev = head;
        ListNode newHead = head.next;
        head.next = prev;
        return reverseListRecursive(newPrev, newHead);
    }
}
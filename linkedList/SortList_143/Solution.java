package LeetCode.linkedList.SortList_143;

/*
148. Sort List
https://leetcode.com/problems/sort-list/

Sort a linked list in O(n log n) time using constant space complexity.
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
    // Time complexity O(n*log n) - because of merge sort.
    // Good solution: use two pointers to get middle.
    // https://discuss.leetcode.com/topic/643/i-have-a-pretty-good-mergesort-method-can-anyone-speed-up-the-run-time-or-reduce-the-memory-usage
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return mergeSort1(head, len);
    }

    private ListNode mergeSort1(ListNode head, int len) {
        if (len<2 || head==null || head.next == null) {
            head.next = null;
            return head;
        }
        ListNode headRight = head;
        for (int i=0; i<len/2; i++) {
            headRight = headRight.next;
        }
        int lenA = len/2, lenB = len - len/2;
        ListNode headA = mergeSort1(head, lenA);
        ListNode headB = mergeSort1(headRight, lenB);
        ListNode headNext = new ListNode(0);
        ListNode curr = headNext;
        while (headA != null && headB != null) {
            if  (headA.val < headB.val) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr = curr.next;
        }
        curr.next = (headA == null) ? headB : headA;
        return headNext.next;
    }

    // https://discuss.leetcode.com/topic/11021/basically-it-seems-like-merge-sort-problem-really-easy-understand
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode walker = head; // head of second list.
        ListNode runner = head; // helper to find middle.
        ListNode tail = head; // tail of first list
        while (runner!= null && runner.next != null) {
            tail = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        tail.next = null; // cut list into two separated lists.

        ListNode headA = sortList(head);
        ListNode headB = sortList(walker);
        ListNode headNext = new ListNode(0);
        ListNode curr = headNext;
        while (headA != null && headB != null) {
            if  (headA.val < headB.val) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr = curr.next;
        }
        curr.next = (headA == null) ? headB : headA;
        return headNext.next;
    }

}
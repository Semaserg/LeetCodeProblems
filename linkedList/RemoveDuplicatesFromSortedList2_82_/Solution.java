package LeetCode.linkedList.RemoveDuplicatesFromSortedList2_82_;

/*
82. Remove Duplicates from Sorted List II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/#/description

Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fh = new ListNode(-1);
        fh.next = head;
        ListNode curr = fh;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int toDel = curr.next.val;
                ListNode temp = curr.next;
                while (temp != null && temp.val == toDel) temp = temp.next;
                curr.next = temp;
            } else {
                curr = curr.next;
            }
        }
        return fh.next;
    }
}
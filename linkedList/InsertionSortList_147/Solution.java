package LeetCode.linkedList.InsertionSortList_147;

/*
147. Insertion Sort List
https://leetcode.com/problems/insertion-sort-list/

Sort a linked list using insertion sort.
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
    // main idea to build new list from items of existing one.
    // because this is linked list - no space overhead.
    // https://discuss.leetcode.com/topic/8570/an-easy-and-clear-way-to-sort-o-1-space
    // Time complexity O(n^2), Space complexity O(1)
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // start of absolutely new linked list
        ListNode fakeHead = new ListNode(0);

        // runner which starts from the beginning for each element starting from 2nd.
        ListNode pre = fakeHead;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            // find correct place in new list
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            curr.next = pre.next;
            pre.next = curr;

            // set pre to the beginning of new list.
            pre = fakeHead;
            curr = next;
        }
        return fakeHead.next;
    }
}
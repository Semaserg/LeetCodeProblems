package LeetCode.linkedList.LinkedListCycle2_142;

/*
142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Explanation
// https://discuss.leetcode.com/topic/5284/concise-o-n-solution-by-using-c-with-detailed-alogrithm-description
// https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation
// https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (runner == walker) {
                ListNode entry = head;
                while (entry != walker) {
                    entry = entry.next;
                    walker = walker.next;
                }
                return entry;
            }
        }
        return null;
    }
}
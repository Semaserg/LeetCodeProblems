package LeetCode.linkedList.SwapNodesInPairs_24;

/*
24. Swap Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list,
 only nodes itself can be changed.
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
    // Time complexity O(n), space complexity O(n) - because recursion affects the stack.
    // https://discuss.leetcode.com/topic/10649/my-simple-java-solution-for-share/2 - not recursive solution
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode a = head;
        ListNode b = head.next;
        ListNode nextA = b.next;
        b.next = a;
        a.next = swapPairs(nextA);
        return b;
    }
}
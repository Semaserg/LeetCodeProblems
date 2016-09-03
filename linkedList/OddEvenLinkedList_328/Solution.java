package LeetCode.linkedList.OddEvenLinkedList_328;

/*
328. Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/

Given a singly linked list, group all odd nodes together followed by the even nodes.
 Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity
 and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
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
    // Good solution
    // https://discuss.leetcode.com/topic/34292/simple-o-n-time-o-1-space-java-solution
    // Time complexity O(n), space complexity O(1).
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode current = head;
        ListNode lastOdd = head;
        boolean isOdd = true;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = current.next.next;
            current = next;
            isOdd = !isOdd;
            lastOdd = (isOdd) ? current : lastOdd;
        }
        lastOdd.next = evenHead;
        return head;
    }
}
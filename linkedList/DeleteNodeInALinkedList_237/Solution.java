package LeetCode.linkedList.DeleteNodeInALinkedList_237;

/*
237. Delete Node in a Linked List
https://leetcode.com/problems/delete-node-in-a-linked-list/

Write a function to delete a node (except the tail) in a singly linked list,
 given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
the linked list should become 1 -> 2 -> 4 after calling your function.
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
    public void deleteNode(ListNode node) {
        if (node == null) return;
        while (node != null) {
            node.val = node.next.val;
            node.next = (node.next.next == null) ? null : node.next;
            node = node.next;
        }
    }

    // Great solution
    // https://discuss.leetcode.com/topic/28267/easy-solution-in-java
    public void deleteNode1(ListNode node) {
        node.val=node.next.val; // copy next value in linked list
        node.next=node.next.next; // skip next node, with value we copied before.
    }
}
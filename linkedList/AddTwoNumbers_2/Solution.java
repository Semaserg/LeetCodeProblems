package LeetCode.linkedList.AddTwoNumbers_2;

/*
2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain
a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode beforeHead = new ListNode(-1);
        int extra = 0;
        ListNode current = beforeHead;
        while (l1 != null || l2 != null || extra>0) {
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            int sum = (a + b + extra) % 10;
            extra = (a + b + extra) > 9 ? 1 : 0;
            current.next = new ListNode(sum);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return beforeHead.next;
    }
}
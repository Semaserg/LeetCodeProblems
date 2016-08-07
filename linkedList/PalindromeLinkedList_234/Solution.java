package LeetCode.linkedList.PalindromeLinkedList_234;

/*
234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    // Great way how to find the middle with two pointers
    // https://discuss.leetcode.com/topic/18304/share-my-c-solution-o-n-time-and-o-1-memory
    // https://discuss.leetcode.com/topic/37978/the-fastest-two-solutions-space-cost-o-n-and-o-1-in-c-with-comments
    // Great explanation
    // https://discuss.leetcode.com/topic/18293/11-lines-12-with-restore-o-n-time-o-1-space
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 1. find length
        int len = 0;
        ListNode curr = head;
        while (curr!= null) {
            len++;
            curr = curr.next;
        }
        // 2. revers first half of linked list
        //ListNode secondItem = head.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        for (int i=1; i<=len/2; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // 3. find heads of the fist and second halfs
        ListNode right = (len%2 == 0) ? current : current.next;
        ListNode left = prev;
        while (left != null && right != null) {
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }
        return true;
    }
}

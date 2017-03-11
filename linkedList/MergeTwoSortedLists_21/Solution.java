package LeetCode.linkedList.MergeTwoSortedLists_21;

/*
21. Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
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


    // Time complexity O(n+m), n - l1 len, m - l2 len.
    // https://discuss.leetcode.com/topic/4480/clean-simple-o-n-m-c-solution-without-dummy-head-and-recurtion
    // Great recursive solution
    // https://discuss.leetcode.com/topic/45002/java-1-ms-4-lines-codes-using-recursion
    // https://discuss.leetcode.com/topic/5513/my-recursive-way-to-solve-this-problem-java-easy-understanding

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Validation;
        if (l1==null && l2==null) return null;
        if (l1==null) return l2;
        if (l2==null) return l1;

        // Set head of new list;
        ListNode res = new ListNode(-1);

        ListNode current = res;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int val2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if (val1<val2) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return res.next;
    }
}
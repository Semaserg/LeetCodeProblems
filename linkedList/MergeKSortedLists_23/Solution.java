package LeetCode.linkedList.MergeKSortedLists_23;

/*
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
*/

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // No priority Queue solution
    // n - lists array length, s - max linked list size
    // Time complexity O(n^2*s), space O(n)
    // Time limit exceeded in leetcode => need to use Heap.
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0);
        ListNode head = fakeHead;
        boolean hasNext = lists.length != 0;
        while (hasNext) {
            int notNullCounter = 0;
            int currIndex = 0;
            ListNode minNode = lists[0];
            for (int i=0; i<lists.length; i++) {
                if (lists[i] != null) {
                    if (minNode == null || lists[i].val < minNode.val) {
                        minNode = lists[i];
                        currIndex = i;
                    }
                    notNullCounter++;
                }
            }
            hasNext = notNullCounter > 0;
            head.next = minNode;
            head = head.next;
            lists[currIndex] = (minNode == null) ? null : minNode.next;

        }
        return fakeHead.next;
    }

    // https://discuss.leetcode.com/topic/2780/a-java-solution-based-on-priority-queue
    // n - lists array length, k - total node count
    // Time complexity O(k*log n), space O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0);
        ListNode head = fakeHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists) {
            if (node != null) heap.add(node);
        }
        while (!heap.isEmpty()) {
            ListNode current = heap.poll();
            head.next = current;
            head = head.next;

            if (current.next != null) {
                heap.add(current.next);
            }
        }
        return fakeHead.next;
    }

}
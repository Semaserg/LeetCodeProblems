package LeetCode.linkedList.LinkedListRandomNode_382;

/*
382. Linked List Random Node
https://leetcode.com/problems/linked-list-random-node/

Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly.
Each element should have equal probability of returning.
*/

import java.util.Random;

public class Solution {
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    // https://en.wikipedia.org/wiki/Reservoir_sampling
    // https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling
    /* My explanation for current problem.
    In our case K = 1. Reservoir size is 1 - we need only one random node from the list.
    In this algorithm we iteration from the beginning till the end of the list,
    if we stop in the middle - we get the random element from the [1 .. middle] of the list.
    Thus we could use this approach for the list with unknown length.

    From the beginning count == 1, and random (1) == 1. So the probability to change the res to curr == 1 (100%)
    for the second iteration count ==2, random(2) == 1 or 2 (1/2 probability for 1 ad 1/2 probability for 2) =>
    probability to change the res to the current is 1/2.
    For the last element:
    count == n, random(n) == [1..n], probability to change is 1/n.
    (my proof is not absolutely correct, check wikipedia for more info)
    * */
    public int getRandom() {
        ListNode res = this.head;
        ListNode curr = this.head;
        int count = 1;
        while (curr != null) {
            int p = new Random().nextInt(count);
            if (p == 1) {
                res = curr;
            }
            curr = curr.next;
            count++;
        }
        return res.val;
    }
}
package LeetCode.linkedList.CopyListWithRandomPointer_138;

/*
138. Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // My O(n) time and space complexity.
    private HashMap<Integer, RandomListNode> cache = new HashMap<>();
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) return null;
        if (!cache.containsKey(head.label)) {
            RandomListNode clone = new RandomListNode(head.label);
            cache.put(head.label, clone);
            clone.next = copyRandomList1(head.next);
            clone.random = copyRandomList1(head.random);
        }
        return cache.get(head.label);
    }

    // https://discuss.leetcode.com/topic/18086/java-o-n-solution
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // step 1: create map which contains pairs <OrigNode, CloneNode>.
        // Clone node has only label at this stage, next and random are null.
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // step 2: run through orig list and make updates to clone nodes: set next and random.
        node = head;
        while (node != null) {
            RandomListNode clone = map.get(node);
            clone.next = map.get(node.next);
            clone.random = map.get(node.random);
            node = node.next;
        }
        RandomListNode cloneHead = map.get(head);
        return cloneHead;
    }
}
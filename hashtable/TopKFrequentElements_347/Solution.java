package LeetCode.hashtable.TopKFrequentElements_347;

import java.util.*;

/*
347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {
    // Time complexity O(2*n + k*log n)
    // n - array to hashmap
    // n - hashmap to heap
    // k*log n - get k times most frequent elements.
    public List<Integer> topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        // you can use this instead of custom object
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
//                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        PriorityQueue<MyEntry> heap = new PriorityQueue<MyEntry>(new MyComparator());
        for (int key : map.keySet()) {
            heap.add(new MyEntry(key, map.get(key)));
        }
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<k; i++) {
            res.add(heap.poll().key);
        }
        return res;
    }

    // Heap, time complexity O(n + (n-k)*log k + n*log k + k*log k) =>
    // O(n + n*log k - k*log k + n*log k + k*log k) => O(n + 2*n*log k) => O(n + n*log k)
    // n - array to map
    // (n-k)*log k - extract elements greater then k from the heap
    // n*log k - add all elements to the heap
    // k*log k - heap to linked list
    //https://discuss.leetcode.com/topic/48158/3-java-solution-using-array-maxheap-treemap
    // Bucket sort
    // https://discuss.leetcode.com/topic/44237/java-o-n-solution-bucket-sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // n
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry); // n*log k
            if (heap.size()>k) heap.poll(); //(n-k)*log k
        }
        List<Integer> res = new LinkedList<>();
        while(!heap.isEmpty()) {
            res.add(heap.poll().getKey()); //k*log k
        }
        return res;
    }
}

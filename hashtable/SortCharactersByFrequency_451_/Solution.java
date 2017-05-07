package LeetCode.hashtable.SortCharactersByFrequency_451_;

import java.lang.reflect.Array;
import java.util.*;

/*
451. Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/#/description
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
public class Solution {
    // https://discuss.leetcode.com/topic/66024/java-o-n-bucket-sort-solution-o-nlogn-priorityqueue-solution-easy-to-understand
    // https://discuss.leetcode.com/topic/65947/o-n-easy-to-understand-java-solution
    // Time O(n *log n), space O(2n) -> O(n)
    public String frequencySort(String s) {
        if (s == null) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b)->(b.count-a.count));
        for (Map.Entry entry : map.entrySet()) {
            heap.add(new Pair((char)entry.getKey(), (int)entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Pair p = heap.poll();
            for(int i=0; i<p.count; i++) {
                sb.append(p.character);
            }
        }
        return sb.toString();
    }

    // bucket sort, time O(n), space O(n)
    public String frequencySort1(String s) {
        if (s == null) return null;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            int cnt = map.get(c)+1;
            map.put(c, cnt);
            max = Math.max(max, cnt);
        }
        ArrayList<Character>[] buckets = new ArrayList[max+1];
        for (Map.Entry entry: map.entrySet()) {
            int cnt = (int)entry.getValue();
            char c = (char)entry.getKey();
            if(buckets[cnt] == null) buckets[cnt] = new ArrayList<>();
            buckets[cnt].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int b=buckets.length-1; b>=0; b--) {
           if (buckets[b] != null) {
               for (char c : buckets[b]) {
                   for (int i=0; i<b; i++) {
                       sb.append(c);
                   }
               }
           }
        }
        return sb.toString();
    }
}
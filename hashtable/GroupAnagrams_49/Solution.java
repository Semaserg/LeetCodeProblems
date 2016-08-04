package LeetCode.hashtable.GroupAnagrams_49;

import java.util.*;

/*
49. Group Anagrams
https://leetcode.com/problems/anagrams/

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
public class Solution {

    // n - strs length, m - max word length
    // Space complexity - O(n*m + n*m) => O(m*n) - first n*m - List<String> in the map, second - keys.
    // Time complexity - O(n*m*log m)
    // https://discuss.leetcode.com/topic/24494/share-my-short-java-solution
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        /*for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }*/
        return new ArrayList<List<String>>(map.values());
    }
    // Time Limit Exceeded
    // Time complexity - O(n^2*a^2), n - strs length, a - max word length; space complexity -  O(2na) => O(na)
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashSet<Integer> set = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (int i=0; i<strs.length; i++) {
            if (set.contains(i)) continue;
            List<String> currentList = new ArrayList<>();
            currentList.add(strs[i]);
            set.add(i);
            HashMap<Character, Integer> map = buildMap(strs[i]);
            for (int j=i+1; j<strs.length; j++) {
                if (set.contains(j)) continue;
                boolean isAnagram = isAnagram(map, strs[i], strs[j]);
                if (isAnagram) {
                    currentList.add(strs[j]);
                    set.add(j);
                }
            }
            if (!currentList.isEmpty()) result.add(currentList);
        }
        return result;
    }

    private HashMap<Character, Integer> buildMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) map.put(c, 1);
            else map.put(c, cnt+1);
        }
        return map;
    }

    private boolean isAnagram(HashMap<Character, Integer> map, String a, String b) {
        if (a.length() != b.length()) return false;
        HashMap<Character, Integer> mapCopy = new HashMap<>(map);
        for (int i=0; i<b.length(); i++) {
            Character c = b.charAt(i);
            Integer cnt = mapCopy.get(c);
            if (cnt == null) return false;
            else {
                if (cnt==1) mapCopy.remove(c);
                else mapCopy.put(c, cnt-1);
            }
        }
        return mapCopy.isEmpty();
    }
}
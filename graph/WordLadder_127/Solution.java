package LeetCode.graph.WordLadder_127;

import java.util.*;

/**
 https://leetcode.com/problems/word-ladder/description/
 127. Word Ladder

 Given two words (beginWord and endWord), and a dictionary's word list,
 find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 UPDATE (2017/1/20):
 The wordList parameter had been changed to a list of strings (instead of a set of strings).
 Please reload the code definition to get the latest changes
*/

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> g = buildGraph(beginWord, endWord, wordList);
        return bfs(beginWord, endWord, g);
    }

    public List<String> ladderPath(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> g = buildGraph(beginWord, endWord, wordList);
        return bfsPath(beginWord, endWord, g);
    }

    private Map<String, Set<String>> buildGraph(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        graph.put(beginWord, new HashSet<>());
        graph.put(endWord, new HashSet<>());
        for (String s : wordList) {
            graph.put(s, new HashSet<>());
        }
        for(String f : graph.keySet()) {
            for (String s : graph.keySet()) {
                if (isOneCharDist(f, s)) {
                    graph.get(f).add(s);
                    graph.get(s).add(f);
                }
            }
        }
        return graph;
    }


    private int bfs(String beginWord, String endWord, Map<String, Set<String>> graph) {
        int pathLen = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int qsize = queue.size();
            for (int i=0; i<qsize; i++) {
                String curr = queue.remove();
                if (curr.equals(endWord)) return pathLen;
                for(String adj : graph.get(curr)) {
                    if (!visited.contains(adj)) {
                        visited.add(adj);
                        queue.add(adj);
                    }
                }
            }
            pathLen++;
        }
        return 0;
    }

    public List<String> bfsPath(String beginWord, String endWord, Map<String, Set<String>> graph) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Map<String, String> pathTo = new HashMap<>();
        while(!queue.isEmpty()) {
            String curr = queue.remove();
            for(String adj : graph.get(curr)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    pathTo.put(adj, curr);
                    queue.add(adj);
                }
            }
        }
        List<String> path = new ArrayList<>();
        String curr = endWord;
        while (curr != beginWord) {
            path.add(0, curr);
            curr = pathTo.get(curr);
        }
        path.add(0, curr);
        return path;
    }

    private boolean isOneCharDist(String first, String second) {
        for (int i=0; i<first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i+1).equals(second.substring(i+1));
            }
        }
        return false;
    }
}
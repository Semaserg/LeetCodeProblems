package LeetCode.graph.AlienDictionary_269;

/*
269. Alien Dictionary
https://leetcode.com/problems/alien-dictionary/

There is a new alien language which uses the latin alphabet.
However, the order among letters are unknown to you. You receive a
list of words from the dictionary, where words are sorted lexicographically
by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

import java.util.*;

// Great bfs solution
// https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs

// My solution looks correct, but it fails for some test cases.
public class Solution {
    HashMap<Character, HashSet<Character>> graph = new HashMap<>();
    HashMap<Character,Integer> inDegree = new HashMap<>();

    public String alienOrder1(String[] words) {
        if (words == null || words.length == 0) return "";

        ArrayList<String> allWords = new ArrayList<>(Arrays.asList(words));
        buildGraph(allWords, 0);

        HashSet<Character> visited = new HashSet();
        Stack<Character> resultStack = new Stack<>(); // to store topological sort results
        HashSet<Character> recursionSet = new HashSet<>(); // to check loops

        char root = getRoot(inDegree);
        if (root == '$') return "";

        // topological sort via dfs
        boolean isValid = isValidDFS(root, visited, resultStack, recursionSet);
        if (!isValid) return "";

        StringBuilder res = new StringBuilder();
        while (!resultStack.isEmpty()) res.append(resultStack.pop());

        return res.toString();
    }

    // looks like I'm wrong building the grapg
    // I should compare the letters in two consequent words till the end of smaller one.
    // Because of we have not info to compare the rest of the bigger word.
    void  buildGraph(ArrayList<String> words, int position) {
        if (words.isEmpty()) return;
        ArrayList<String> nextLevel = new ArrayList<>();

        char prev = '$';
        for (String word : words) {
            if (position < word.length()) {
                char current = word.charAt(position);
                graph.putIfAbsent(current, new HashSet<>());
                inDegree.putIfAbsent(current, 0);

                if (prev != '$') {
                    if (prev != current) {
                        graph.putIfAbsent(prev, new HashSet<>());
                        graph.get(prev).add(current); // add edge prev->current
                        inDegree.put(current, inDegree.get(current)+1); // set in degree of current vertex

                        buildGraph(nextLevel, position+1);
                        nextLevel.clear();
                    }
                }

                nextLevel.add(word);
                prev = current;
            }
        }
        if (!nextLevel.isEmpty()) {
            buildGraph(nextLevel, position+1);
        }
    }

    // this is enough to check loops + check is graph connected.
    // So recursionSet in redundant.
    // Only one ventex with InDegree==0 should exists. In other case we have not connected graph or loop.
    char getRoot(HashMap<Character,Integer> inDegree) {
        char root = '$';
        for(char key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                if (root == '$') root = key;
                else return '$'; // we found second vertex with InDegree equals 0.
            }
        }
        return root;
    }

    boolean isValidDFS(char current, HashSet<Character> visited, Stack<Character> resultStack, HashSet<Character> recursionSet) {
        if (visited.contains(current)) return true;
        if (recursionSet.contains(current)) return false;

        visited.add(current);
        recursionSet.add(current);

        for (Character adjVertex : graph.get(current)) {
            if (!visited.contains(adjVertex)) {
                boolean isValid = isValidDFS(adjVertex, visited, resultStack, recursionSet);
                if (!isValid) return false;
            }
        }

        recursionSet.remove(current);
        resultStack.push(current);
        return true;
    }

    // Kahn alg
    // https://en.wikipedia.org/wiki/Topological_sorting
    // https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs
    String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();

        if (words == null || words.length <= 1) return "";

        for (int i=0; i<words.length-1; i++) {
            char[] prevWord = words[i].toCharArray();
            char[] nextWord = words[i+1].toCharArray();
            int len = Math.min(prevWord.length, nextWord.length);
            for(int j = 0; j<len; j++) {
                char prev = prevWord[j];
                char next = nextWord[j];

                // init structure
                if (!graph.containsKey(prev)) graph.put(prev, new HashSet<>());
                if (!graph.containsKey(next)) graph.put(next, new HashSet<>());
                if (!degree.containsKey(prev)) degree.put(prev, 0);
                if (!degree.containsKey(next)) degree.put(next, 0);

                // no data to compare the characters
                if (prev == next) continue;

                // increase in-degree for the next char
                // if it is not done yet
                if (!graph.get(prev).contains(next)) {
                    graph.get(prev).add(next);
                    degree.put(next, degree.get(next) + 1);
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.remove();
            res.append(curr);
            Set<Character> nextChars = graph.get(curr);
            for (char c : nextChars) {
                degree.put(c, degree.get(c)-1); // decrease degree
                if (degree.get(c) == 0) q.add(c);
            }
        }
        if (res.length() != degree.size()) return "";
        return res.toString();
    }
}

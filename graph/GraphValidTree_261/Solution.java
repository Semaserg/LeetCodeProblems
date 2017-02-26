package LeetCode.graph.GraphValidTree_261;

import javafx.util.Pair;

import java.util.*;

/*
261. Graph Valid Tree
https://leetcode.com/problems/graph-valid-tree/?tab=Description

Given n nodes labeled from 0 to n - 1 and a list of undirected edges
(each edge is a pair of nodes), write a function to check whether these
edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected
graph in which any two vertices are connected by exactly one path. In other
words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since
all edges are undirected, [0, 1] is the same as [1, 0] and thus will not
appear together in edges.
*/
// it can be done with union-find algorithm
//http://www.geeksforgeeks.org/union-find/
//https://discuss.leetcode.com/topic/21712/ac-java-union-find-solution
public class Solution {
    private int visitedCount = 0;

    // DFS solution
    // Time complexity O(n)
    // Space complexity O(n)
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges == null) return false;
        LinkedList<Integer>[] graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        boolean hasCycle = isCycle(0, -1, graph, visited);
        if (hasCycle) return false;
        return visitedCount==n; // all vertices have been visited
    }

    private boolean isCycle(int current, int parent, LinkedList<Integer>[] graph, boolean[] visited) {
        if (visited[current]) return true;
        visited[current] = true;
        visitedCount++;

        LinkedList<Integer> adjVertices = graph[current];
        for (Integer vertex : adjVertices) {
            if (vertex != parent) {
                boolean isCycle = isCycle(vertex, current, graph, visited);
                if (isCycle) return true;
            }
        }
        return false;
    }

    // BFS solution
    // Time complexity O(n), n - number of vertices
    // Space complexity - O(n) - number of vertices
    public boolean validTree1(int n, int[][] edges) {
        if (n == 0 || edges == null) return false;
        LinkedList<Integer>[] graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        int visitedCnt = 0;
        // Pair<Integer, Integer>> - because we need the parent Id.
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, -1));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentPair = queue.poll();
            int current = currentPair.getKey();
            int parent = currentPair.getValue();
            if (visited[current]) {
                return false; // vertex is already visited, so we found the cycle.
            }
            visited[current] = true;
            visitedCnt++;

            LinkedList<Integer> adjacentVertices = graph[current];
            for (int vertex : adjacentVertices) {
                if (vertex != parent) queue.add(new Pair<>(vertex, current));
            }
        }
        return visitedCnt == n;
    }

    private LinkedList<Integer>[] buildGraph(int n, int[][] edges) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i=0; i<n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
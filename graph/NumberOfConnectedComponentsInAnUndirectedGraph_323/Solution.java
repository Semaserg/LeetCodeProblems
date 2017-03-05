package LeetCode.graph.NumberOfConnectedComponentsInAnUndirectedGraph_323;

import java.util.*;

/**
 323. Number of Connected Components in an Undirected Graph
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/?tab=Description

Given n nodes labeled from 0 to n - 1 and a list of undirected edges
(each edge is a pair of nodes), write a function to find the number
of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since
all edges are undirected, [0, 1] is the same as [1, 0] and thus will
not appear together in edges.
*/

public class Solution {

    // Union-Find method
    // https://discuss.leetcode.com/topic/32752/easiest-2ms-java-solution
    // Time complexity - O(n) (thx to path compression, with no path compression it is O(n^2) )
    // Space complexity O(1)
    // http://www.geeksforgeeks.org/union-find/
    public int countComponents1(int n, int[][] edges) {
        if (n == 0 || edges == null) return 0;
        //LinkedList<Integer>[] graph = buildGraph(n, edges);

        int[] parents = new int[n];
        for (int i=0; i<n; i++) parents[i] = i;

        for(int[] edge : edges) {
            union(edge[0], edge[1], parents);
        }

        HashSet<Integer> roots = new HashSet<>();
        for(int i=0; i<n; i++) {
            int root = find(i, parents);
            roots.add(root);
        }
        return roots.size();
    }

    // get rid of recursion + add path compression
    int find(int i, int[] parents) {
        if (i == parents[i]) return i;
        else {
            parents[i] = find(parents[i], parents); // path compression
            return parents[i];
        }
    }

    void union(int i, int j, int[] parents) {
        int iParent = find(i, parents);
        int jParent = find(j, parents);
        parents[iParent] = jParent;
    }

    public int countComponents2(int n, int[][] edges) {
        if (n == 0 || edges == null) return 0;
        LinkedList<Integer>[] graph = buildGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    // Time - O(m+n, m - number of  vertices, n - number of edges)
    void dfs(int current, LinkedList<Integer>[] graph, boolean[] visited) {
        if (visited[current]) return;
        visited[current] = true;

        LinkedList<Integer> adjacentVertices = graph[current];
        for (int v : adjacentVertices) {
            dfs(v, graph, visited);
        }
    }

    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null) return 0;
        LinkedList<Integer>[] graph = buildGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, graph, visited);
            }
        }
        return count;
    }

    // Time - O(m+n, m - number of  vertices, n - number of edges)
    void bfs(int startVertex, LinkedList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            LinkedList<Integer> adjacentVertices = graph[current];
            for (int v : adjacentVertices) {
                if (!visited[v]) queue.add(v);
            }
        }
    }

    LinkedList<Integer>[] buildGraph(int n, int[][] edges) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i=0; i<n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
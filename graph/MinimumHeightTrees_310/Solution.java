package LeetCode.graph.MinimumHeightTrees_310;

import jdk.nashorn.internal.ir.IndexNode;

import java.util.*;

/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/

For a undirected graph with tree characteristics, we can choose any node as the root.
 The result graph is then a rooted tree. Among all possible rooted trees, those with
 minimum height are called minimum height trees (MHTs). Given such a graph, write a
 function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the
number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are
undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?
Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which
 any two vertices are connected by exactly one path. In other words, any connected graph
 without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between
the root and a leaf.
*/

public class Solution {

    // https://discuss.leetcode.com/topic/30572/share-some-thoughts
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) return Collections.singletonList(0);

        Set<Integer>[] graph = makeGraph(n, edges);
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i=0; i<n; i++) {
            // node with only one edge is the leave.
            if (graph[i].size() == 1) leaves.add(i);
        }
        while(n>2) {
            n = n - leaves.size();
            ArrayList<Integer> nextLeaves = new ArrayList<>();
            for(int l : leaves) {
                Set<Integer> adjacentNodes = graph[l];
                for (int node : adjacentNodes) {
                    // remove edges from current leaves to next level => generate next leaves.
                    graph[node].remove(l);
                    if (graph[node].size() == 1) {
                        nextLeaves.add(node);
                    }
                }
            }
            leaves = nextLeaves;
        }
        return leaves;
    }

    private Set<Integer>[] makeGraph(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n];
        for(int i=0; i<n; i++){
            graph[i] = new HashSet<>();
        }
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }
}
package LeetCode.graph.CommutableIslands_intbit;

/*
Commutable Islands
https://www.interviewbit.com/problems/commutable-islands/

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario
in which all islands are connected with each other.

Example :
Input

         Number of islands ( n ) = 4
         1 2 1
         2 3 4
         1 4 3
         4 3 2
         1 3 10
In this example, we have number of islands(n) = 4 . Each row then represents a bridge configuration.
In each row first two numbers represent the islands number which are connected by this
bridge and the third integer is the cost associated with this bridge.

In the above example, we can select bridges 1(connecting islands 1 and 2 with cost 1),
3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4 and 3 with cost 2).
Thus we will have all islands connected with the minimum possible cost(1+3+2 = 6).
In any other case, cost incurred will be more.
*/

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private PriorityQueue<Edge> pq;
    private Queue<Edge> mst;
    private Graph graph;
    private boolean[] visited;
    private int sum = 0;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if (A == 0 || B == null || B.size() == 0) return 0;
        graph = new Graph(A, B);
        pq = new PriorityQueue<Edge>((a,b) -> a.weight() - b.weight());
        mst = new LinkedList<>();
        visited = new boolean[A+1];

        visit(1); // 1 - is the start point
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            int v = curr.other();
            int w = curr.either(v);

            if (visited[v] && visited[w]) continue;
            mst.add(curr);
            sum += curr.weight();

            if (!visited[v]) visit(v);
            if (!visited[w]) visit(w);
        }

        return sum;
    }

    private void visit(int v) {
        visited[v] = true;
        for(Edge e : graph.adj(v)) {
            if (!visited[e.either(v)] || !visited[e.other()]) {
                pq.add(e);
            }
        }
    }
}

class Graph {
    private final int size;
    private final Set<Edge>[] edges;

    Graph(int A, ArrayList<ArrayList<Integer>> B) {
        this.size = A;
        this.edges = new Set[A+1];
        for (int i=1; i<=A; i++) {
            this.edges[i] = new HashSet<>();
        }
        for(ArrayList<Integer> l : B) {
            Edge e = new Edge(l.get(0), l.get(1), l.get(2));
            addEdge(e);
        }
    }

    private void addEdge(Edge e) {
        int v = e.other();
        int w = e.either(v);
        edges[v].add(e);
        edges[w].add(e);
    }

    public Set<Edge> adj(int v) {
        return edges[v];
    }
}

class Edge {
    private final int v, w, weight;

    public int other() {
        return v;
    }

    public int either(int v) {
        if (this.v == v) return w;
        return v;
    }

    public int weight() {
        return weight;
    }

    Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
}

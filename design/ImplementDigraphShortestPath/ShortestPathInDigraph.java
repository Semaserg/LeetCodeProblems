package LeetCode.design.ImplementDigraphShortestPath;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find shortest path from source vertex to some other vertex
 */
public class ShortestPathInDigraph {
    private Digraph digraph;
    private int size;
    private boolean[] marked;
    private int[] edgeTo;

    public ShortestPathInDigraph(Digraph G, int startVertex) {
        marked = new boolean[G.size()];
        edgeTo = new int[G.size()];
        for (int i=0; i<G.size(); i++) {
            edgeTo[i] = -1;
        }
        size = G.size();
        digraph = G;
        bfs(digraph, startVertex);
    }

    // Multiple-source shortest path.
    public ShortestPathInDigraph(Digraph G, List<Integer> startVertices) {
        marked = new boolean[G.size()];
        edgeTo = new int[G.size()];
        for (int i=0; i<G.size(); i++) {
            edgeTo[i] = -1;
        }
        size = G.size();
        digraph = G;
        bfs(digraph, startVertices);
    }

    private void bfs(Digraph g, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        marked[start] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (Integer w : g.adj(curr)) {
                if (!marked[w]) {
                    edgeTo[w] = curr;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    private void bfs(Digraph g, List<Integer> startVertices) {
        Queue<Integer> q = new LinkedList<>();
        for(Integer i : startVertices) {
            q.add(i);
            marked[i] = true;
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (Integer w : g.adj(curr)) {
                if (!marked[w]) {
                    edgeTo[w] = curr;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    Iterable<Integer> getPath(int w) {
        LinkedList<Integer> res = new LinkedList<>();
        int curr = w;
        while (curr != -1) {
            res.add(0, curr);
            curr = edgeTo[curr];
        }
        return res;
    }
}

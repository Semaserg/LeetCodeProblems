package LeetCode.design.ImplementDigraphShortestPath;

import java.util.HashSet;
import java.util.Set;

/**
 * Graph implementation
 */
public class Digraph {
    // graph size, so vertices names should be in [0 .. V-1] diapason.
    // we can use hashmap to connect real vertex names with this index.
    private int V;
    private Set<Integer>[] adj;

    public Digraph(int v) {
        this.V = v;
        this.adj = new Set[v];
        for (int i=0; i<v; i++) {
            this.adj[i] = new HashSet<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public int size() {
        return this.V;
    }
}

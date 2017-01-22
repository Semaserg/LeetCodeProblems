package LeetCode.design.ImplementShortestPathTreeViaDijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * Edge Weighted Digraph implementation
 */
public class EdgeWeightedDigraph {
    private final int _size;
    private final Set<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int size) {
        this._size = size;
        adj = new Set[size];
        for (int i=0; i<size; i++) {
            adj[i] = new HashSet<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
    }

    public Iterable<DirectedEdge> adj(int from) {
        return adj[from];
    }

    public int size() {
        return this._size;
    }
}

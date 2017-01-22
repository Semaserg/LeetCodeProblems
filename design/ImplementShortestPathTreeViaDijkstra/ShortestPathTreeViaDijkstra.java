package LeetCode.design.ImplementShortestPathTreeViaDijkstra;

import java.util.LinkedList;

/**
 * Dijkstra algorithm implementation
 */
public class ShortestPathTreeViaDijkstra {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    private int _source;

    public ShortestPathTreeViaDijkstra(EdgeWeightedDigraph graph, int source) {
        this._source = source;
        edgeTo = new DirectedEdge[graph.size()];
        distTo = new double[graph.size()];
        pq = new IndexMinPQ<>(graph.size());
        for (int i=0; i<graph.size(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;
        pq.insert(source, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : graph.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    public LinkedList<DirectedEdge> pathTo(int target) {
        LinkedList<DirectedEdge> result = new LinkedList<>();
        DirectedEdge curr = edgeTo[target];
        while (curr.from() != _source) {
            result.add(0, curr);
            curr = edgeTo[curr.from()];
        }
        result.add(0, curr);
        return result;
    }
}

package LeetCode.design.ImplementShortestPathTreeViaDijkstra;

/**
 * Directed edge implementation
 */
public class DirectedEdge {
    private final int _from, _to;
    private final double _weight;

    public DirectedEdge(int from, int to, double weight) {
        this._from = from;
        this._to = to;
        this._weight = weight;
    }

    public int from() { return this._from; }
    public int to() { return this._to; }
    public double weight() { return this._weight; }

    @Override
    public String toString() {
        return this._from + "->" + this._to + "(" + this.weight() + "); ";
    }
}

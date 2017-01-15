package LeetCode.design.ImplementGraphBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth first search implementation.
 */
public class BreadthFirstSearch {
    private boolean[] marked; // all items false by default
    private int[] edgeTo; // contains parentId of each the node
    private int startVertex; // start vertex
    private Graph graph;
    private LinkedList items;

    public BreadthFirstSearch(Graph g, int startVertex, int size) {
        marked = new boolean[size];
        edgeTo = new int[size];
        for (int i=0; i<size; i++) {
            edgeTo[i] = -1;
        }
        this.graph = g;
        this.startVertex = startVertex;
        this.items = new LinkedList();
        this.items = bfs(startVertex);
    }

    public Iterable<Integer> getItems() {
        return this.items;
    }

    public Iterable<Integer> getPath(int endVertex) {
        LinkedList ls = new LinkedList();
        int curr = endVertex;
        while (curr > -1) {
            ls.add(curr);
            curr = edgeTo[curr];
        }
        return ls;
    }

    private LinkedList bfs(int start) {
        LinkedList result = new LinkedList();
        Queue<Integer> queue = new LinkedList<>();

        marked[start] = true;
        result.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    result.add(w);
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
        return result;
    }
}

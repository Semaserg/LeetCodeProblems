package LeetCode.design.ImplementGraphDfs;

import java.util.LinkedList;

/**
 * DFS implementation
 */
public class DepthFirstSearch {
    private boolean[] marked; // all items false by default
    private int[] edgeTo; // contains parentId of each the node
    private int startVertex; // start vertex
    private Graph graph;
    private LinkedList items;

    public DepthFirstSearch(Graph g, int startVertex, int size) {
        marked = new boolean[size];
        edgeTo = new int[size];
        for (int i=0; i<size; i++) {
            edgeTo[i] = -1;
        }
        this.graph = g;
        this.startVertex = startVertex;
        this.items = new LinkedList();
        dfs(startVertex, items);
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

    private void dfs(int current, LinkedList result) {
        if (marked[current]) return;

        marked[current] = true;
        result.add(current);

        for (int w : graph.adj(current)) {
            if (!marked[w]) {
                dfs(w, result);
                edgeTo[w] = current;
            }
        }
    }

}

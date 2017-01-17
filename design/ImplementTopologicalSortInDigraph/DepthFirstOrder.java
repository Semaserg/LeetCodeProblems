package LeetCode.design.ImplementTopologicalSortInDigraph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological sort implementation
 */
public class DepthFirstOrder {
    Digraph digraph;
    private boolean[] marked;
    private LinkedList<Integer> list;

    public DepthFirstOrder(Digraph g) {
        digraph = g;
        list = new LinkedList<>();
        marked = new boolean[g.size()];
        for (int i=0; i<g.size(); i++) {
            if (!marked[i]) {
                dfs(g, i, list);
            }
        }
    }

    private void dfs(Digraph g, int curr, LinkedList<Integer> list) {
        marked[curr] = true;
        for (Integer i : g.adj(curr)) {
            if (!marked[i]) {
                dfs(g, i, list);
            }
        }
        list.add(0, curr);
    }

    public Iterable<Integer> getTopologicalOrder() {
        return list;
    }
}

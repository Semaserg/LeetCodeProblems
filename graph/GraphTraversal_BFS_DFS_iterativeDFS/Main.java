package LeetCode.graph.GraphTraversal_BFS_DFS_iterativeDFS;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(2, 0);

        List<Integer> d1 = g.dfs(0);
        System.out.println(d1.stream().map(c -> c.toString()).collect(Collectors.joining(",")));

        List<Integer> d2 = g.dfsIterative(0);
        System.out.println(d2.stream().map(c -> c.toString()).collect(Collectors.joining(",")));

        List<Integer> d3 = g.bfs(0);
        System.out.println(d3.stream().map(c -> c.toString()).collect(Collectors.joining(",")));
    }
}



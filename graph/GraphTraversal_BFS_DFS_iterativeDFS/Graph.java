package LeetCode.graph.GraphTraversal_BFS_DFS_iterativeDFS;

import java.util.*;

public class Graph {
    private final List<Integer>[] adjList;
    private final int size;
    public Graph(int size) {
        this.size = size;
        adjList = new List[size];
        for (int i=0; i<size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public List<Integer> dfs(int root) {
        List<Integer> res = new LinkedList<>();
        boolean[] visited = new boolean[size];
        dfsRecursive(root, visited, res);
        return res;
    }

    private void dfsRecursive(int current, boolean[] visited, List<Integer> res) {
        visited[current] = true;
        res.add(current);
        for (int i : adjList[current]) {
            if (!visited[i]) {
                //visited[i] = true;
                res.add(i);
            }
        }
    }

    public List<Integer> dfsIterative(int root) {
        boolean[] visited = new boolean[size];
        List<Integer> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            result.add(curr);
            for(int a : adjList[curr]) {
                if (!visited[a]) {
                    visited[a] = true;
                    stack.push(a);
                }
            }
        }
        return result;
    }

    public List<Integer> bfs(int root) {
        boolean[] visited = new boolean[size];
        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            result.add(curr);
            for (int a:adjList[curr]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
        return result;
    }
}

//class Node<T> {
//    public final T value;
//    public final List<Node> adjacent;
//    Node(T value) {
//        this.value = value;
//        adjacent = new LinkedList<>();
//    }
//}

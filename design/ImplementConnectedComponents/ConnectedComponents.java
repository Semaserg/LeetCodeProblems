package LeetCode.design.ImplementConnectedComponents;

/**
 * Connected components implementation
 */
public class ConnectedComponents {
    private boolean[] marked;
    private int[] componentId; // componentId[v] == id of connected component.
    private int count = 0; // count of connected components
    private Graph graph;
    private int size;

    public ConnectedComponents(Graph g) {
        size = g.size();
        graph = g;
        marked = new boolean[size];
        componentId = new int[size];
        for (int i=0; i<size; i++) {
            componentId[i] = -1;
        }

        for (int i=0; i<size; i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int curr) {
        //if (marked[curr]) return;

        marked[curr] = true;
        componentId[curr] = count;
        for (Integer w : graph.adj(curr)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }

    public boolean isConnected(int v, int w) {
        return componentId[v] == componentId[w];
    }
}

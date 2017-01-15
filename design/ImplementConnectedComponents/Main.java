package LeetCode.design.ImplementConnectedComponents;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(4,2);
        g.addEdge(2,3);
        g.addEdge(0,3);
        g.addEdge(0,4);
        g.addEdge(2,1);

        ConnectedComponents d = new ConnectedComponents(g);
        System.out.println(d.isConnected(0, 4));
        System.out.println(d.isConnected(0, 5));
    }
}



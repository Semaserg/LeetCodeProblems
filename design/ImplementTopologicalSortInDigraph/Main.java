package LeetCode.design.ImplementTopologicalSortInDigraph;

public class Main {
    public static void main(String[] args) {
        Digraph g = new Digraph(7);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(3, 5);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(3, 6);
        g.addEdge(3, 4);
        g.addEdge(6, 4);
        g.addEdge(3, 2);

        DepthFirstOrder d = new DepthFirstOrder(g);
        Iterable<Integer> path = d.getTopologicalOrder();

        System.out.println("Topological order: ");
        for(Integer i : path) {
            System.out.print(i + "->");
        }
    }
}



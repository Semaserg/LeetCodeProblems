package LeetCode.design.ImplementShortestPathTreeViaDijkstra;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(5);
        g.addEdge(new DirectedEdge(0,1,1.0));
        g.addEdge(new DirectedEdge(0,2,3.0));
        g.addEdge(new DirectedEdge(0,3,2.0));
        g.addEdge(new DirectedEdge(3,2,2.0));
        g.addEdge(new DirectedEdge(2,4,1.0));
        g.addEdge(new DirectedEdge(1,4,6.0));

        ShortestPathTreeViaDijkstra dijkstra = new ShortestPathTreeViaDijkstra(g, 0);
        LinkedList<DirectedEdge> path = dijkstra.pathTo(4); // should be 0->2 (3.0)  2->4 (1.0)
        for (DirectedEdge e : path) {
            System.out.print(e);
        }

//        Digraph g = new Digraph(5);
//        g.addEdge(0,1);
//        g.addEdge(1,2);
//        g.addEdge(3,4);
//        g.addEdge(4,2);
//        g.addEdge(2,3);
//        g.addEdge(0,3);
//        g.addEdge(0,4);
//        g.addEdge(2,1);
//
//        ShortestPathInDigraph d = new ShortestPathInDigraph(g, 0);
//        Iterable<Integer> path = d.getPath(2);
//
//        System.out.println("from 0 to 2");
//        for(Integer i : path) {
//            System.out.print(i + "->");
//        }
//
//        List<Integer> source = new ArrayList<>(Arrays.asList(new Integer[] {4,0,1}));
//        ShortestPathInDigraph d1 = new ShortestPathInDigraph(g, source);
//        Iterable<Integer> path1 = d1.getPath(2);
//
//        System.out.println("");
//        System.out.println("Multiple-source shortest path. from 0 to 2");
//        for(Integer i : path1) {
//            System.out.print(i + "->");
//        }
    }
}



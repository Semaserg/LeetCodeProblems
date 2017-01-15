package LeetCode.design.ImplementGraphBfs;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(4,2);
        g.addEdge(2,3);
        g.addEdge(0,3);
        g.addEdge(0,4);
        g.addEdge(2,1);

        BreadthFirstSearch d = new BreadthFirstSearch(g, 0, 5);
        Iterable<Integer> all = d.getItems();
        Iterable<Integer> path = d.getPath(2);
        for(Integer i : all) {
            System.out.print(i + ", ");
        }
        System.out.println("from 0 to 2");
        for(Integer i : path) {
            System.out.print(i + "->");
        }
    }
}



package LeetCode.graph.NumberOfConnectedComponentsInAnUndirectedGraph_323;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {3,4}};
        int result = s.countComponents(5, edges);
        System.out.println(result);
    }
}



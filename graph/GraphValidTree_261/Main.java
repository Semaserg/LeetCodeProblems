package LeetCode.graph.GraphValidTree_261;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}};
        int[][] edges = new int[][]{};
        boolean result = s.validTree(1, edges);
        System.out.println(result);
    }
}



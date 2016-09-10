package LeetCode.graph.CloneGraph_133;

public class Main {
    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        Solution s = new Solution();
        UndirectedGraphNode res = s.cloneGraph(node);
        System.out.print(res.label);
    }
}



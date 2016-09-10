package LeetCode.graph.CloneGraph_133;

import java.util.ArrayList;
import java.util.List;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors = new ArrayList<>();
    UndirectedGraphNode(int x) {
        label = x;
    }
}

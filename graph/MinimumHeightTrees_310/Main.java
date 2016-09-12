package LeetCode.graph.MinimumHeightTrees_310;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre = new int[][]{{0,1}, {1,2}, {1,3}};
        List<Integer> result = s.findMinHeightTrees(4, pre);
        System.out.println(result);
    }
}



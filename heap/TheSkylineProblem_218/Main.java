package LeetCode.heap.TheSkylineProblem_218;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<int[]> res = s.getSkyline(new int[][] {
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        });
        // [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
        for(int[] i : res){
            System.out.print(String.format("%s %s; ", i[0], i[1]));
        }

    }
}



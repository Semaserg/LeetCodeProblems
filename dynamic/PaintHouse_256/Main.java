package LeetCode.dynamic.PaintHouse_256;

public class Main {
    public static void main(String[] args) {
        int[][] costs = new int[][] {{1,2,3}, {5,2,3}, {7,2,3}};
        Solution n = new Solution();
        int result = n.minCost(costs);
        System.out.print(result);
    }
}



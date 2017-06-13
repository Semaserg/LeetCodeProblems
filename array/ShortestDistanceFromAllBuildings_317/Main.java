package LeetCode.array.ShortestDistanceFromAllBuildings_317;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        1 - 0 - 2 - 0 - 1
//        |   |   |   |   |
//        0 - 0 - 0 - 0 - 0
//        |   |   |   |   |
//        0 - 0 - 1 - 0 - 0
        int[][] matrix = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        int result = s.shortestDistance(matrix);
        System.out.println(result);
    }
}



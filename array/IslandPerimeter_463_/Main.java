package LeetCode.array.IslandPerimeter_463_;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        int res = s.islandPerimeter(nums);
        System.out.print(res);
    }
}




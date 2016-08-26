package LeetCode.unionFind.NumberOfIslands_200;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = new char[][]{{'0','0','1'}, {'0', '1', '1'}, {'1', '0', '0'}};
        int result = s.numIslands(grid);
        System.out.print(result);
    }
}

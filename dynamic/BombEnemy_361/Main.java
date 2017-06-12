package LeetCode.dynamic.BombEnemy_361;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = new char[][] {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };
        int result = s.maxKilledEnemies(grid);
        System.out.println(result);
    }
}

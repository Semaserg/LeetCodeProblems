package LeetCode.backTracking.WordSearch_79;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {// ["ABCE","SFES","ADEE"]
        {'A','B','C','E'},
        {'S','F','E','S'},
        {'A','D','E','E'}
        };
//        char[][] board = {{'A', 'A'}};
        boolean result = s.exist(board, "ABCESEEEFS") ;
        System.out.println(result);
    }
}

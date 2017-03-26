package LeetCode.hashtable.ValidSudoku_36;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] sudoku = new char[][]{
                {'1', '4','.', '2'},
                {'2', '3','.', '.'},
                {'3', '2','.', '.'},
                {'4', '1','.', '.'}};
        boolean result = s.isValidSudoku(sudoku);
        System.out.println(result);

        Solution1 s1 = new Solution1();
        boolean result1 = s1.isValidSudoku(sudoku);
        System.out.println(result1);

        Solution2 s2 = new Solution2();
        boolean result2 = s2.isValidSudoku(sudoku);
        System.out.println(result2);

    }
}



package LeetCode.backTracking.SudokuSolver_37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        char [][] sudoku = new char[][]{
                {'1','.','.','4'},
                {'4','.','.','1'},
                {'.','1','.','.'},
                {'.','.','.','.'}
        };
        s.solveSudoku(sudoku);

        for (int i=0; i<sudoku.length; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
    }
}


package LeetCode.backTracking.SudokuSolver_37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
37. Sudoku Solver
https://leetcode.com/problems/sudoku-solver/#/description

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
public class Solution1 {
    private final int smallSize = 2;
    private final int bigSize = 4;
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        sudokuValidate();
        boolean success = backTrack();
        if (!success) throw new RuntimeException("Sudoku has no solutions");
    }

    // https://discuss.leetcode.com/topic/11327/straight-forward-java-solution-using-backtracking
    // Try 1 through 9 for each cell. The time complexity should be 9 ^ m
    // (m represents the number of blanks to be filled in), since each blank can have 9 choices.
    private void sudokuValidate() {
        if (board == null || board.length != bigSize || board[0] == null || board[0].length != bigSize){
            throw new IllegalArgumentException("Sudoku is not valid");
        }
    }

    private boolean backTrack() {
        for (int row = 0; row<bigSize; row++) {
            for (int col=0; col<bigSize; col++) {
                char current = board[row][col];
                if (current != '.') continue;

                for (char i='1'; i<'1'+bigSize; i++) { // from 1 to 9
                    if (isValid(row, col, i)) {
                        board[row][col] = i;

                        if (backTrack()) {
                            return true;
                        } else {
                            board[row][col] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char value) {
        for (int i=0; i<bigSize; i++){
            // check column
            if (board[row][i] == value) return false;
            if (board[i][col] == value) return false;
            //3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3
            int x = smallSize * (row/smallSize) + i/smallSize;
            int y = smallSize * (col/smallSize) + i%smallSize;
            if (board[x][y] == value) return false;
        }
        return true;
    }
}

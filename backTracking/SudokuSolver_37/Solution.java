package LeetCode.backTracking.SudokuSolver_37;

import javafx.util.Pair;

import java.util.*;

/*
37. Sudoku Solver
https://leetcode.com/problems/sudoku-solver/#/description

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
// THIS SOLUTION DOSE NOT WORKING!
public class Solution {
    private final int smallSize = 2;
    private final int bigSize = 4;
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        sudokuValidate();
        backTrack(null, null, null, 0, 0);
    }

    private void sudokuValidate() {
        if (board == null || board.length != bigSize || board[0] == null || board[0].length != bigSize){
            throw new IllegalArgumentException("Sudoku is not valid");
        }
    }

    private boolean backTrack(Set<Character> rowSet, Set<Character> colSet, Set<Character> boxSet, int row, int col) {
        // check that row, column and box are filled properly
        //if (rowSet.size() == bigSize && colSet.size() == bigSize && rowSet.size() == bigSize) return true;
        //  check boundaries
        if (row == bigSize || col == bigSize || row < 0 || col < 0) return true;
        char current = board[row][col];
        if (current != '.') {
            return backTrack(null, null, null, row+1, col) && backTrack(null, null, null, row, col+1);
        }

        if (rowSet == null) rowSet = getRowSet(row);
        if (colSet == null) colSet = getColSet(col);
        if (boxSet == null) boxSet = getBoxSet(smallSize*(row/smallSize), smallSize*(col/smallSize));
        Set<Character> candidates = getFullSet();
        candidates.removeAll(rowSet);
        candidates.removeAll(colSet);
        candidates.removeAll(boxSet);

        for(Character candidate : candidates) {
            board[row][col] = candidate;
            rowSet.add(candidate);
            colSet.add(candidate);
            boxSet.add(candidate);

            boolean success = backTrack(null, null, null, row+1, col) && backTrack(null, null, null, row, col+1);
            if (success) return true;
            else {
                board[row][col] = '.';
                rowSet.remove(candidate);
                colSet.remove(candidate);
                boxSet.remove(candidate);
            }

        }
        return false;
    }

    private Set<Character> getFullSet() {
        char[] full = new char[]{ '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<Character> set = new HashSet(Arrays.asList(full));
        return set;
    }

    private Set<Character> getRowSet(int row) {
        Set<Character> set = new HashSet();
        for (char c : board[row]) {
            if (c != '.') set.add(c);
        }
        return set;
    }

    private Set<Character> getColSet(int col) {
        Set<Character> set = new HashSet();
        for (int i=0; i<bigSize; i++) {
            char current = board[i][col];
            if (current != '.') set.add(current);
        }
        return set;
    }

    private Set<Character> getBoxSet(int rowStart, int colStart) {
        Set<Character> set = new HashSet();
        for (int i=rowStart; i<rowStart+smallSize; i++) {
            for (int j=colStart; j<colStart+smallSize; j++) {
                char current = board[i][j];
                if (current != '.') set.add(current);
            }
        }
        return set;
    }
}

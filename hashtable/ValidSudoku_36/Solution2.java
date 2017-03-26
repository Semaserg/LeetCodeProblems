package LeetCode.hashtable.ValidSudoku_36;

import java.util.HashSet;
import java.util.Set;

/*
36. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/#/description

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
public class Solution2 {
    private final int innerSize = 2;
    private final int outerSize = 4;

    private void inputValidation(char[][] board) {
        if (board == null) throw new IllegalArgumentException("board should be provided");
        if (board.length != outerSize || board[0] == null || board[0].length != outerSize) {
            throw new IllegalArgumentException("board size is not correct");
        }
    }

    private boolean isCellDataValid(char item) {
        if (item == '.') return true;
        if (Character.isDigit(item)) {
            int itemValue = item - '0';
            return itemValue > 0 && itemValue <= outerSize;
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        inputValidation(board);
        for (int row=0; row<outerSize; row++) {
            if (!isPortionValid(board, 0, row, outerSize, row)) return false;
        }
        for (int col=0; col<outerSize; col++) {
            if (!isPortionValid(board, col, 0, col, outerSize)) return false;
        }

        for (int row=0; row<outerSize; row=row+innerSize) {
            for (int col=0; col<outerSize; col=col+innerSize){
                if (!isPortionValid(board, col, row, col+innerSize, row+innerSize)) return false;
            }
        }
        return true;
    }

    private boolean isPortionValid(char[][] board, int xFrom, int yFrom, int xTo, int yTo) {
        Set<Character> set = new HashSet<>();
        for (int x=xFrom; x<xTo; x++) {
            for (int y=yFrom; y<yTo; y++) {
                char current = board[x][y];
                if (!isCellDataValid(current)) {
                    throw new RuntimeException(String.format("%1$c is not valid cell data ", current));
                }
                if (current != '.' && !set.add(current)) return false;
            }
        }
        return true;
    }
}
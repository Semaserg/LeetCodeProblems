package LeetCode.hashtable.ValidSudoku_36;

import java.util.HashSet;
import java.util.Set;

/*
36. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/#/description

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
public class Solution1 {
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

    private boolean  isPortionValid(char item, Set<Character> set) {
        if (!isCellDataValid(item)) throw new RuntimeException(String.format("%1$c is not valid cell data ", item));
        if (item == '.') return true;
        return set.add(item);
    }

    // Great solutions
    // https://discuss.leetcode.com/topic/9748/shared-my-concise-java-code
    // https://discuss.leetcode.com/topic/5803/sharing-my-easy-understand-java-solution-using-set
    public boolean isValidSudoku(char[][] board) {
        inputValidation(board);
        for (int i=0; i<outerSize; i++) {
            Set<Character> rowItems = new HashSet<>();
            Set<Character> colItems = new HashSet<>();
            Set<Character> squareItems = new HashSet<>();
            for (int j=0; j<outerSize; j++) {
                if (!isPortionValid(board[i][j], rowItems)) return false;
                if (!isPortionValid(board[j][i], colItems)) return false;

                int rowStart = innerSize*(i/innerSize);
                int colStart = innerSize*(i%innerSize);
                if (!isPortionValid(board[rowStart + j/innerSize][colStart+j%innerSize], squareItems)) return false;
            }
        }
        return true;
    }
}
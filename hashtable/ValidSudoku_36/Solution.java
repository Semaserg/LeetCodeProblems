package LeetCode.hashtable.ValidSudoku_36;

import java.util.HashSet;
import java.util.Set;

/*
36. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/#/description

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
public class Solution {
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

    private boolean  hasData(char item) {
        return item != '.';
    }

    private int getCellValue(char item) {
        if (!Character.isDigit(item)) throw new IllegalArgumentException("item should be digit");
        return item - '0';
    }

    private boolean isValid(char item, Set<Integer> set) {
        if (!isCellDataValid(item)) throw new RuntimeException(String.format("%1$c is not valid cell data ", item));
        if (!hasData(item)) return true;
        int itemValue = getCellValue(item);
        if (set.contains(itemValue)) {
            return false;
        }
        set.add(itemValue);
        return true;
    }

    // Solution #1:
    // 3 passes, 3 HashSets -> O(3n)->O(n) time, O(innerSize) space
    public boolean isValidSudoku(char[][] board) {
        inputValidation(board);
        for (int i=0; i<outerSize; i++) {

            Set<Integer> horizontalItems = new HashSet<>();
            Set<Integer> verticalItems = new HashSet<>();

            for (int j=0; j<outerSize; j++) {
                char nextHorizontal = board[i][j];
                boolean isHorizontalValid = isValid(nextHorizontal, horizontalItems);
                if (!isHorizontalValid) return false;

                char nextVertical = board[j][i];
                boolean isVerticalValid = isValid(nextVertical, verticalItems);
                if (!isVerticalValid) return false;
            }
        }

        for (int i=0; i<outerSize; i=i+innerSize) {
            for (int j = 0; j < outerSize; j = j + innerSize) {
                Set<Integer> bigCellItems = new HashSet<>();

                for (int iInner = i; iInner < i + innerSize; iInner++) {
                    for (int jInner = j; jInner < j + innerSize; jInner++) {
                        char current = board[iInner][jInner];
                        boolean isValid = isValid(current, bigCellItems);
                        if (!isValid) return false;
                    }
                }
            }
        }
        return true;
    }
}
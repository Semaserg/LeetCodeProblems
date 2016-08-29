package LeetCode.backTracking.WordSearch_79;

import java.util.HashMap;
import java.util.Map;

/*
79. Word Search
https://leetcode.com/problems/word-search/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    // Great explanation
    // https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space/14
    // Time complexity k=m*n O(k^2) - because for each cell  we can do whole board traversal.
    // Space complexity O(1).
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        /*for (int k=0; k<n*m; k++) {
            int i = k/n;
            int j = k%n;
            if (findPath(board, i, j, word, 0)) {
                return true;
            }
        }*/
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (findPath(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] board, int i, int j, String word, int index) {
        // word is completely checked.
        if (index == word.length()) return true;

        // check the boundaries.
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) return false;

        // check the current cell.
        if (board[i][j] != word.charAt(index)) return false;

        // current cell has correct letter, mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '$';

        // if current cell is ok, try to find path for the next char.
        boolean top = findPath(board, i-1, j, word, index+1);
        boolean bottom = findPath(board, i+1, j, word, index+1);
        boolean left = findPath(board, i, j-1, word, index+1);
        boolean right = findPath(board, i, j+1, word, index+1);
        if (top || bottom || left || right) return true;

        // restore visited cell
        board[i][j] = temp;
        return false;
    }
}
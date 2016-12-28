package LeetCode.dynamic.SentenceScreenFitting_418;

/*
418. Sentence Screen Fitting
https://leetcode.com/problems/sentence-screen-fitting/

Given a rows x cols screen and a sentence represented by a list of words,
find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output:
2

Explanation:
a-bcd-
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output:
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
*/
public class Solution {
    private int counter = 0;
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0 || rows == 0 || cols == 0) return 0;
        //addWord(sentence, 0, 0, 0, rows, cols);
        //return counter;
        return addSentense(sentence, rows, cols);
    }

    // My recursive brute force solution
    // This solution has "Line 19: java.lang.StackOverflowError" in LeetCode
    void addWord(String[] sentence, int currWordIndex, int currRow, int currCol, int rows, int cols) {
        if (currWordIndex == sentence.length) { // sentence was completely added
            counter++;
            currWordIndex = 0;
        }

        if (currRow >= rows) return; // we done
        int lineRemainder = cols - currCol;
        String currWord = sentence[currWordIndex];

        if (lineRemainder <= 0 || currWord.length() > lineRemainder) { // is currCol is more than cols OR word is too big for the rest of the line
            addWord(sentence, currWordIndex, currRow+1, 0, rows,cols); // try to add in the next line
        } else if (currWord.length() == lineRemainder){ // word is successfully added in the current line, and no empty cells in the end of the line
            addWord(sentence, currWordIndex+1, currRow+1, 0, rows,cols); // try to add next word in the next line
        } else { // word is successfully added in the current line, and some empty cells in the end of the line
            addWord(sentence, currWordIndex+1, currRow, currCol+ + currWord.length() + 1, rows,cols); // try to add next word in the same line
        }
    }

    // My iterative brute force solution
    // Time Limit Exceeded
    int addSentense(String[] sentence, int rows, int cols) {
        int result = 0, currWordIndex = 0, currRow = 0, currCol = 0;

        while (currRow < rows) {
            int lineRemainder = cols - currCol;
            String currWord = sentence[currWordIndex];

            if (lineRemainder <= 0 || currWord.length() > lineRemainder) { // is currCol is more than cols OR word is too big for the rest of the line
                currRow++;// try to add same word in the next line
                currCol = 0;
            } else if (currWord.length() == lineRemainder){ // word is successfully added in the current line, and no empty cells in the end of the line
                currWordIndex++;
                currRow++;// try to add next word in the next line
                currCol = 0;
            } else { // word is successfully added in the current line, and some empty cells in the end of the line
                currWordIndex++;
                currCol += currWord.length() + 1; // try to add next word in the same line
            }

            if (currWordIndex == sentence.length) {
                result++;
                currWordIndex = 0;
            }
        }
        return result;
    }

    // My iterative bulk solution
    // Stupid and not working for some cases.
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0 || rows == 0 || cols == 0) return 0;
        int cnt = 0;
        String sentenceStr = String.join(" ", sentence) + " ";
        String prev = sentenceStr;
        for (int i=0; i<rows; i++) {
            // prev part of the sentence has size of cols or cols-1, so just increment the counter and go to the next row
            if (prev.length() == rows || prev.length()-1 == rows) {
                cnt++;
                prev = sentenceStr;
                System.out.println("Case 1.");
            }
            // prev is smaller than cols:
            // 1. add prev
            // 2. calc the remainder and try to set whole sentence as much time as possible
            // 3. calc next version of prev
            else if (prev.length() < cols) {
                // 1. add prev
                cnt++;

                System.out.println("Case 2. Prev Before = " + prev);
                // 2. calc the remainder and try to set whole sentence as much time as possible
                int remainder = cols - prev.length();
                int localCnt = remainder / sentenceStr.length();
                cnt += localCnt;

                // 3. calc next version of prev
                int nextRemainder = remainder - sentenceStr.length() * localCnt;
                String s = sentenceStr.substring(0, nextRemainder);
                int partOfSentenceInCurrLine = sentenceStr.substring(0, nextRemainder+1).lastIndexOf(" ");
                prev = sentenceStr.substring(partOfSentenceInCurrLine+1);
                System.out.println("Case 2. Prev After = " + prev);
            }
            // prev is bigger than cols, so calc the part of the prev which should be used in the next row.
            // Set it as next prev.
            else if (prev.length() > cols) {
                System.out.println("Case 3. Prev Before = " + prev);
                int partOfSentenceInCurrLine = prev.substring(0, cols+1).lastIndexOf(" ");
                prev = prev.substring(partOfSentenceInCurrLine+1);
                System.out.println("Case 3. Prev After = " + prev);
            }
        }
        return cnt;
    }
}
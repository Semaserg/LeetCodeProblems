package LeetCode.backTracking.WordSquares_425;

import java.util.ArrayList;
import java.util.List;

/*
425. Word Squares
https://leetcode.com/problems/word-squares/#/description

Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square
because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter
(just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter
(just the order of words in each word square matters).
*/
public class Solution {
    // Good solution with trie
    // https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16
    // Trie
    // http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
    // http://algs4.cs.princeton.edu/52trie/TrieST.java.html

    Trie trie;
    int size;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;

        trie = Trie.fromArray(words);
        size = words[0].length();

        List<String> answerBuilder = new ArrayList<>();
        for (String w : words) {
            answerBuilder.add(w);
            backTrack(result, answerBuilder);
            answerBuilder.remove(w);
        }
        return result;
    }

    private void backTrack(List<List<String>> result, List<String> answerBuilder) {
        if (answerBuilder.size() == size) {
            result.add(new ArrayList<>(answerBuilder));
            return;
        }
        String prefix = buildPrefix(answerBuilder);
        List<String> options = trie.getByPrefix(prefix);
        for(String w : options) {
            answerBuilder.add(w);
            backTrack(result, answerBuilder);
            answerBuilder.remove(w);
        }
    }

    private String buildPrefix(List<String> answerBuilder) {
        int index = answerBuilder.size();
        StringBuilder sb = new StringBuilder();
        for (String w : answerBuilder) {
            sb.append(w.charAt(index));
        }
        return sb.toString();
    }
}
package LeetCode.array.ShortestWordDistance_243;

import java.util.Random;
import java.util.Stack;

/**
 243. Shortest Word Distance
 https://leetcode.com/problems/shortest-word-distance/#/description

 Given a list of words and two words word1 and word2,
 return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2,
 and word1 and word2 are both in the list.
 */

public class Solution {
    // https://discuss.leetcode.com/topic/20668/ac-java-clean-solution
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, dist = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) p1 = i; // do not use "==" it doesn't work in leetcode judge.
            else if (words[i].equals(word2)) p2 = i;

            if (p1 != -1 && p2 != -1) {
                dist = Math.min(dist, Math.abs(p1-p2));
            }
        }
        return dist;
    }
}
package LeetCode.array.HIndex_274;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 274. H-Index
 https://leetcode.com/problems/h-index/

 Given an array of citations (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia:
 "A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers
 in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the
 researcher has 3 papers with at least 3 citations each and the remaining two with no more
 than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 Hint:

 An easy approach is to sort the array first.
 What are the possible values of h-index?
 A faster approach is to use extra space.
 */
public class Solution {
    // Bucket sort solution, time complexity O(2*n) => O(n), space complexity O(n)
    // https://discuss.leetcode.com/topic/40765/java-bucket-sort-o-n-solution-with-detail-explanation
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int[] buckets = new int[len + 1];
        for(int i:citations) {
            if (i > len) buckets[len]++;
            else buckets[i]++;
        }
        int total = 0;
        for(int i=len; i>=0; i--){
            total+=buckets[i];
            if (total>=i) return i;
        }
        return 0;
    }

    // Sort solution, time complexity O(n*log n), space complexity O(1)
    // https://discuss.leetcode.com/topic/25560/simple-java-solution-with-sort
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int h = citations.length;
        for (int c :citations) {
            if (c<h) h--;
            else return h;
        }
        return 0;
    }
}
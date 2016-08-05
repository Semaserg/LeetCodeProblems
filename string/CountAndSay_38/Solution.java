package LeetCode.string.CountAndSay_38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
38. Count and Say
https://leetcode.com/problems/count-and-say/

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Subscribe to see which companies asked this question
*/
// https://discuss.leetcode.com/topic/2264/examples-of-nth-sequence - explanation what is nth sequence.
// Good solutions using recursion
// https://discuss.leetcode.com/topic/41718/my-simple-java-solution/2
// https://discuss.leetcode.com/topic/20195/c-solution-easy-understand
public class Solution {

     // Time complexity ?, space complexity ?
    public String countAndSay(int n) {
        if (n<1) return "";
        if (n==1) return "1";
        int i=2;
        List<Integer> current = Arrays.asList(1,1);
        List<Integer> next = new ArrayList<>();
        while (i<n) {
            int temp = current.get(0);
            int counter = 1;
            for (int j=1; j<current.size(); j++) {
                int currentDigit = current.get(j);
                if (temp == currentDigit) {
                    counter++;
                } else {
                    next.add(counter);
                    next.add(temp);
                    temp = currentDigit;
                    counter=1;
                }
            }
            next.add(counter);
            next.add(temp);
            current = new ArrayList<>(next);
            next.clear();
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int k : current) sb.append(k);
        return sb.toString();
    }

    // How to find next item in sequence
    // k - string representation of n
    // Time complexity O(k), space complexity O(2k+k) => O(3k) => O(k).
    /*public String getNext(int n) {
        if (n>=0 && n<=9) return "1"+n;
        List<Integer> digits = new ArrayList<>();
        while (n>0) {
            digits.add(0, n%10);
            n = n/10;
        }
        StringBuilder sb = new StringBuilder();
        int temp = digits.get(0);
        int counter = 1;
        for (int i=1; i<digits.size(); i++) {
            int current = digits.get(i);
            if (temp == current) {
                counter++;
            } else {
                sb.append(counter);
                sb.append(temp);
                temp = current;
                counter=1;
            }
        }
        sb.append(counter);
        sb.append(temp);
        return sb.toString();
    }*/
}
package LeetCode.hashtable.RepeatedDNASequences_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
187. Repeated DNA Sequences
https://leetcode.com/problems/repeated-dna-sequences/
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that
occur more than once in a DNA molecule.

For example,
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public class Solution {

    // My stupid solution
    public List<String> findRepeatedDnaSequences1(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            if (set.contains(sequence)) result.add(sequence);
            else set.add(sequence);
        }
        return new ArrayList<>(result);
    }

    // HashSet<String> is not enough here, because
    // "If two objects have same hash it means that they may or may not be equal
    // (though two equal objects are required to have same hash). So hashing is not
    // enough here (like calling just "AACCCCCGGG".hashCode() and storing it in the map),
    // because there can be another (different) string with same hash and the program
    // will output wrong result."
    // https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation/9
    // https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<>();
        HashSet<Integer> alreadyDone = new HashSet<>();
        HashSet<Integer> words = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            int code = calcCode(sequence);
            if (words.contains(code)) {
                if (!alreadyDone.contains(code)) {
                    result.add(sequence);
                    alreadyDone.add(code);
                }
            } else {
                words.add(code);
            }
        }
        return result;
    }

    int calcCode(String sequence) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int code = 0;
        for(char c : sequence.toCharArray()) {
            code <<= 2;
            code |= map.get(c);
        }
        return code;
    }
}

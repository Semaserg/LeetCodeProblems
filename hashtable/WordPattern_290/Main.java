package LeetCode.hashtable.WordPattern_290;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean isMatch = s.wordPattern("abba", "dog cat cat dog");
        System.out.print(isMatch);
    }
}



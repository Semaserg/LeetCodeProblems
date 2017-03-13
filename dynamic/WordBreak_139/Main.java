package LeetCode.dynamic.WordBreak_139;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result = s.wordBreak("leetcode", new ArrayList<>(Arrays.asList("le", "leet", "code")));
        System.out.println(result);
    }
}



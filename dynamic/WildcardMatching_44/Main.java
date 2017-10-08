package LeetCode.dynamic.WildcardMatching_44;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result = s.isMatch("baaabab", "ba*****ab");
        System.out.println(result);
    }
}



package LeetCode.hashtable.ValidAnagram_242;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "cat";
        String b = "tca";
        boolean result = s.isAnagram(a,b);
        System.out.print(result);
    }
}



package LeetCode.string.RegularExpressionMatching_10;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result = s.isMatch("bbbba", ".*a*a");
        System.out.println(result);
    }
}

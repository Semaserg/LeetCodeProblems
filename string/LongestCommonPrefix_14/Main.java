package LeetCode.string.LongestCommonPrefix_14;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"aab1", "aab", "aa"};
        String result = s.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

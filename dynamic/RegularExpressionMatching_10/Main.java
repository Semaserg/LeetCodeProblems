package LeetCode.dynamic.RegularExpressionMatching_10;

public class Main {
    public static void main(String[] args) {
        Solution n = new Solution();
        //int result = n.wordsTyping(new String[] {"hello", "world"}, 2, 8); // to be 1
        //int result = n.wordsTyping1(new String[] {"f", "p", "a"}, 8, 7); // to be 10
        //int result = n.wordsTyping1(new String[] {"I", "had", "apple", "pie"}, 4, 5); // to be 1
        //boolean result = n.isMatch("aab", "c*a*b"); // to be 1
        boolean result = n.isMatch("aaa", "a.a"); // to be 1
        System.out.println(result);
    }
}

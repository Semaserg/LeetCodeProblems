package LeetCode.backTracking.WordSquares_425;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[]{
            "abat","baba","atan","atal"
        };
        List<List<String>> result = s.wordSquares(words) ;
        System.out.println(result);
    }
}
//[["abaa","baaa","aaab","aaba"],["abaa","baaa","aaba","aaab"],["aaab","aaba","abaa","baaa"],["abaa","aaab","aaba","abaa"],
//        ["baaa","aaab","aaba","abaa"],["baaa","aaba","abaa","aaab"],["baaa","abaa","aaab","aaba"],
//        ["baaa","abaa","aaba","aaab"],["aaba","aaab","baaa","abaa"],["aaba","abaa","baaa","aaab"]]
//
//[["aaab","aaba","abaa","baaa"],["aaab","abaa","aaba","baaa"],["aaba","aaab","baaa","abaa"],["aaba","abaa","baaa","aaab"],
//        ["abaa","baaa","aaab","aaba"],["abaa","baaa","aaba","aaab"],["baaa","aaab","aaba","abaa"],
//        ["baaa","aaba","abaa","aaab"],["baaa","abaa","aaab","aaba"],["baaa","abaa","aaba","aaab"]]

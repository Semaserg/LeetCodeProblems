package LeetCode.hashtable.SubstringWithConcatenationOfAllWords_30;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> result = s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(result);
    }
}

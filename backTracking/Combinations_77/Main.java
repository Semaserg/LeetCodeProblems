package LeetCode.backTracking.Combinations_77;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(4, 2);
        for (List l : result) {
            System.out.println(l);
        }
    }
}

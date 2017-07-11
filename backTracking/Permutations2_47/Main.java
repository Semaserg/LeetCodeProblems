package LeetCode.backTracking.Permutations2_47;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.permuteUnique(new int[]{1,2,3,2,3});
        for(List<Integer> l : result) {
            System.out.println(l);
        }
    }
}

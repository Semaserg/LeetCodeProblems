package LeetCode.backTracking.CombinationSum_39;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>>  result = s.combinationSum(new int[]{2,3,6,7}, 7) ;
        System.out.println(result);
    }
}

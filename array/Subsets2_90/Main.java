package LeetCode.array.Subsets2_90;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> resuilt = s.subsetsWithDup(new int[]{5,5,5,5,5});
        System.out.print(resuilt);
    }
}



package LeetCode.array.ThreeSum_15;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = s.threeSum(a);
        for (List  l: res) {
            System.out.println(l.toString());
        }
    }
}

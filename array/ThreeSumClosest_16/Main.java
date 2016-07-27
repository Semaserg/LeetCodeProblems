package LeetCode.array.ThreeSumClosest_16;

import java.util.Arrays;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {0,2,1,-3};
        int res = s.threeSumClosest(a, 1);
        System.out.print(res);
    }
}

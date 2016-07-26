package LeetCode.array.MergeSortedArray_88;

import java.util.Arrays;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] a = {2,4,6,0,0,0};
//        int[] b = {1,1,3};
        int[] a = {1, 0};
        int[] b = {2};
        s.merge(a, 1, b, 1);
        System.out.print(Arrays.toString(a));
    }
}



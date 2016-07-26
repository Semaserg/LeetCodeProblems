package LeetCode.array.RemoveDuplicatesFromSortedArray_26;

import java.util.Arrays;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,1,2,2,3,3};
        int len = s.removeDuplicates(a);
        System.out.print(len);
        System.out.print(Arrays.toString(a));
    }
}



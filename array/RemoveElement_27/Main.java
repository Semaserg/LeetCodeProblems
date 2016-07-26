package LeetCode.array.RemoveElement_27;

import java.util.Arrays;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2,3,3,2};
        int result = s.removeElement(a, 3);
        System.out.print(result);
        System.out.print(Arrays.toString(a));
    }
}



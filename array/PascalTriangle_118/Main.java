package LeetCode.array.PascalTriangle_118;

import java.util.List;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Main {
    public static void main(String[] args) {
        Solution tr = new Solution();
        List<List<Integer>> result = tr.generate(10);
        System.out.print(result);
    }
}



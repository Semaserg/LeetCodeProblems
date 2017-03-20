package LeetCode.array.PascalTriangle_118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii on 25.07.2016.
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5, Return:
 * [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 https://en.wikipedia.org/wiki/Pascal's_triangle
 https://discuss.leetcode.com/topic/5128/solution-in-java
 https://discuss.leetcode.com/topic/6805/my-concise-solution-in-java
 */
public class Solution {
    private void generateRecursive(List<List<Integer>> arr, int num) {
        if (arr.size() == num) return;
        List<Integer> prev = arr.get(arr.size()-1);
        int nextLen = prev.size() + 1;
        ArrayList<Integer> next = new ArrayList<Integer>();
        for(int i=0; i<nextLen; i++) {
            int first = (i==0) ? 0 : prev.get(i-1);
            int second = (i==nextLen-1) ? 0 : prev.get(i);
            next.add(first+second);
        }
        arr.add(next);
        generateRecursive(arr, num);
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return result;
        ArrayList<Integer> start = new ArrayList<Integer>();
        start.add(1);
        result.add(start);
        if (numRows == 1) return result;
        generateRecursive(result, numRows);
        return result;
    }

//    GOOD SOLUTION
//    public List<List<Integer>> generate(int numRows)
//    {
//        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        for(int i=0;i<numRows;i++)
//        {
//            row.add(0, 1);
//            for(int j=1;j<row.size()-1;j++)
//                row.set(j, row.get(j)+row.get(j+1));
//            allrows.add(new ArrayList<Integer>(row));
//        }
//        return allrows;
//
//    }
}
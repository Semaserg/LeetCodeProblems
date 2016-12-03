package LeetCode.array.ThirdMaximumNumber_414;

import java.util.ArrayList;
import java.util.List;

/**
 414. Third Maximum Number
 https://leetcode.com/problems/third-maximum-number/

 Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */
public class Solution {
    public int thirdMax(int[] nums) {
        Integer[] top3 = new Integer[3]; // initialized array contains nulls
        for (int i : nums) trySet(top3, i);
        return top3[2] != null ? top3[2] : top3[0];
    }

    void trySet(Integer[] top, int n) {
        int current = n;
        for (int i=0; i<top.length; i++) {
            if (top[i] == null) {
                top[i] = current;
              break;
            }
            if (current == top[i]) {
                break;
            }
            if (current > top[i]) {
                int temp = top[i];
                top[i] = current;
                current = temp;
            }
        }
    }
}
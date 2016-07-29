package LeetCode.array.SearchForARange_34;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] nums = {5,7,7,8,8,8,9,9,10};
        int[] nums = {2,2};
        int[] range = s.searchRange(nums,2);
        System.out.print(Arrays.toString(range));
    }
}



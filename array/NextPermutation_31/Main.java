package LeetCode.array.NextPermutation_31;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,2,5,3,3,0};
        s.nextPermutation(nums);
        System.out.print(Arrays.toString(nums));// 0,1,3,0,2,3,5
    }
}



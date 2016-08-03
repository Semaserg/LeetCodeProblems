package LeetCode.hashtable.TwoSum_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        int[] result = s.twoSum(nums, 6);
        System.out.print(Arrays.toString(result));
    }
}



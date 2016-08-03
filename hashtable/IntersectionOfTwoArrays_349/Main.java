package LeetCode.hashtable.IntersectionOfTwoArrays_349;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums2 = {6,7,8,9};
        int[] result = s.intersection(nums1, nums2);
        System.out.print(Arrays.toString(result));
    }
}



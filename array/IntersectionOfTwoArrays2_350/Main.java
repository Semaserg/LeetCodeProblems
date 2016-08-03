package LeetCode.array.IntersectionOfTwoArrays2_350;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 3, 4, 5, 5, 6, 6};
        int[] nums2 = {5, 6, 6, 0, 30, 76};
        int[] res = s.intersect(nums1, nums2);
        System.out.print(Arrays.toString(res));
    }
}




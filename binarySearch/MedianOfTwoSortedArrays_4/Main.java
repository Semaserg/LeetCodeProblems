package LeetCode.binarySearch.MedianOfTwoSortedArrays_4;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,3};
        int[] b = new int[]{2};
        Solution s = new Solution();
        double result = s.findMedianSortedArrays(a, b);
        System.out.println(result);
    }
}
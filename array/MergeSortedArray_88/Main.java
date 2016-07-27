package LeetCode.array.MergeSortedArray_88;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 0};
        int[] b = {2};
        s.merge(a, 1, b, 1);
        System.out.print(Arrays.toString(a));
    }
}



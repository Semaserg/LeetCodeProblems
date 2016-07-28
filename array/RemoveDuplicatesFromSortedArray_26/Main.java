package LeetCode.array.RemoveDuplicatesFromSortedArray_26;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,1,2,2,3,3};
        int len = s.removeDuplicates(a);
        System.out.print(len);
        System.out.print(Arrays.toString(a));
    }
}



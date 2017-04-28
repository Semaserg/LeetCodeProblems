package LeetCode.array.ShuffleAnArray_384_;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1,2,3,4,5,6,7,8,9,10});
        int[] random = s.shuffle();
        System.out.println(Arrays.toString(random));
        int[] orig = s.reset();
        System.out.println(Arrays.toString(orig));
    }
}



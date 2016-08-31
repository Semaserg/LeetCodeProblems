package LeetCode.array.RotateArray_189;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3};
        s.rotate(array, 2);
        System.out.print(Arrays.toString(array));
    }
}



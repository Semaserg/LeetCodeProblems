package LeetCode.array.WiggleSort2_324;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = new int[]{1,5,1,1,6,4};
        s.wiggleSort(res);
        System.out.print(Arrays.toString(res));
    }
}



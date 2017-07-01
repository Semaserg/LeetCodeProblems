package LeetCode.array.FindAllDuplicatesInAnArray_442;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,3,4,4};
        List<Integer> res = s.findDuplicates(arr);
        System.out.print(res);
    }
}



package LeetCode.array.FindAllNumbersDisappearedInAnArray_448;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = s.findDisappearedNumbers(arr);
        System.out.print(res);
    }
}



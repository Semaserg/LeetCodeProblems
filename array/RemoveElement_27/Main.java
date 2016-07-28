package LeetCode.array.RemoveElement_27;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2,3,3,2};
        int result = s.removeElement(a, 3);
        System.out.print(result);
        System.out.print(Arrays.toString(a));
    }
}



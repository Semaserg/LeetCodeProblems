package LeetCode.array.SortColors_75;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] colors = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        s.sortColors(colors);
        System.out.print(Arrays.toString(colors));
    }
}



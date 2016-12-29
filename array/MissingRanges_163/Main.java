package LeetCode.array.MissingRanges_163;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 3, 50, 75}; // should return ["2", "4->49", "51->74", "76->99"]
        List<String> res = s.findMissingRanges(nums, 0, 99);
        System.out.print(res);
    }
}



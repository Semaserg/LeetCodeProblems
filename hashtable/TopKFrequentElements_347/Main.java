package LeetCode.hashtable.TopKFrequentElements_347;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,2,2,3,4,4,5,6,6,6,6,6,6,7};
        List<Integer> result = s.topKFrequent(nums, 4);
        System.out.print(result.toString());
    }
}



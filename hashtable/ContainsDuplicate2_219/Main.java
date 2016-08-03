package LeetCode.hashtable.ContainsDuplicate2_219;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,3,6,7};
        boolean result = s.containsNearbyDuplicate(nums, 3);
        System.out.print(result);
    }
}



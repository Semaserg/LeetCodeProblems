package LeetCode.hashtable.TwoSum_1;

import java.util.HashMap;

public class Solution {
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int next = target-nums[i];
            map.put(next, i);
        }
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            } else {
                int next = target-nums[i];
                map.put(next, i);
            }
        }
        return new int[]{};
    }
}
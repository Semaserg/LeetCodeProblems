package LeetCode.array.MaxConsecutiveOnes_485;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,0,1,1};
        int max = s.findMaxConsecutiveOnes(nums);
        System.out.print(max);
    }
}



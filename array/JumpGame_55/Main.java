package LeetCode.array.JumpGame_55;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,1,4};
        int[] nums1 = {3,2,1,0,4};
        boolean res = s.canJump(nums1);
        System.out.print(res);
    }
}




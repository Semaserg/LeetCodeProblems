package LeetCode.array.HIndex_274;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,0,6,1,5};
        int hIndex = s.hIndex(nums);
        System.out.print(hIndex);
    }
}



package LeetCode.array.MissingNumber_268;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,9,2,8,3,7,4,6}; // should return 5;
        int res = s.missingNumber(nums);
        System.out.print(res);
    }
}



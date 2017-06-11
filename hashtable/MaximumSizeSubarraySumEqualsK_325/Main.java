package LeetCode.hashtable.MaximumSizeSubarraySumEqualsK_325;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3); // res==4
        System.out.println(result);
    }
}



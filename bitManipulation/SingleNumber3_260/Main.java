package LeetCode.bitManipulation.SingleNumber3_260;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.singleNumber(new int[]{1,2,1,2,3,4,5,4,5,9});
        System.out.println(String.format("[ %1s, %2s ]", result[0], result[1]));
    }
}
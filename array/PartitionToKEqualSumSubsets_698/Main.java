package LeetCode.array.PartitionToKEqualSumSubsets_698;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.canPartitionKSubsets(new int[]{4,15,1,1,1,1,3,11,1,10}, 3);
        System.out.print(res);
    }
}

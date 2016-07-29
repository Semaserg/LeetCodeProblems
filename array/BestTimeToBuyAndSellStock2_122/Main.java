package LeetCode.array.BestTimeToBuyAndSellStock2_122;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] nums = {6,5,5,7,9,9,6,4,3,5,7,6};
        int[] nums = {2,1,2,0,1};
        int profit = s.maxProfit(nums);
        System.out.print(profit);
    }
}



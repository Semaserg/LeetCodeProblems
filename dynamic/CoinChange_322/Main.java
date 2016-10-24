package LeetCode.dynamic.CoinChange_322;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {2,5,1};
        int result = s.coinChange(coins, 11);
        System.out.print(result);
    }
}



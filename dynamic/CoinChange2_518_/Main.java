package LeetCode.dynamic.CoinChange2_518_;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.change(5, new int[]{1,2,5});
        System.out.println(result);
        //System.out.println(s.change(500, new int[]{3,5,7,8,9,10,11}));
    }
}

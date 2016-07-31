package LeetCode.array.CombinationSum3_216;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum3(3,9);
        for (List<Integer> l : result) {
            System.out.print("[ ");
            for (Integer i : l) {
                System.out.print(i + ", ");
            }
            System.out.print(" ]");
        }

    }
}



package LeetCode.graph.CommutableIslands_intbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        list.add(new ArrayList<>(Arrays.asList(2, 3, 5)));
        list.add(new ArrayList<>(Arrays.asList(1, 3, 9)));

        Solution s = new Solution();
        int res = s.solve(3, list);
        System.out.print(res);
    }
}



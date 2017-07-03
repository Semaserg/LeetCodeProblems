package LeetCode.array.MaximumDistanceInArrays_624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{1,4}));
        list.add(Arrays.asList(new Integer[]{0,5}));
        //list.add(Arrays.asList(new Integer[]{1,2,3}));
        int max = s.maxDistance(list);
        System.out.print(max);
    }
}



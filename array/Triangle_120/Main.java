package LeetCode.array.Triangle_120;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        List<Integer> first = Arrays.asList(2);
//        List<Integer> second = Arrays.asList(3,4);
//        List<Integer> third = Arrays.asList(6,5,7);
//        List<Integer> fourth = Arrays.asList(4,1,8,3);
//        List<List<Integer>> triangle = Arrays.asList(first, second, third, fourth);
//[[-1],[2,3],[1,-1,-3]]

        List<Integer> first = Arrays.asList(-1);
        List<Integer> second = Arrays.asList(2,3);
        List<Integer> third = Arrays.asList(1,-1,-3);
        List<List<Integer>> triangle = Arrays.asList(first, second, third);

        int min = s.minimumTotal(triangle);
        System.out.print(min);
    }
}



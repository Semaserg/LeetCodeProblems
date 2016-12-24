package LeetCode.graph.ReconstructItinerary_332;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.findItinerary(new String[][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}});
        System.out.println(result);
    }
}



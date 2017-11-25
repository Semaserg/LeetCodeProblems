package LeetCode.graph.WordLadder_127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(res);

        List<String> path = s.ladderPath("hit", "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(String.join(", ", path));
    }
}


//INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF
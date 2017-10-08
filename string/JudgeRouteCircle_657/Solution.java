package LeetCode.string.JudgeRouteCircle_657;

import java.util.HashMap;
import java.util.Map;

/*
657. Judge Route Circle
https://leetcode.com/problems/judge-route-circle/description/

Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a
character. The valid robot moves are R (Right), L (Left), U (Up) and D (down).
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/
class Solution {
    private final Map<Character, int[]> map = new HashMap<>();
    public Solution() {
        map.put('U', new int[] {-1,0});
        map.put('R', new int[] {0, 1});
        map.put('D', new int[] {1, 0});
        map.put('L', new int[] {0, -1});
    }

    public boolean judgeCircle(String moves) {
        if (moves == null) throw new IllegalArgumentException("ex");
        int[] pos = new int[] {0, 0};
        for (char ch : moves.toCharArray()) {
            if (!map.containsKey(ch)) throw new IllegalStateException("ex1");
            pos[0] += map.get(ch)[0];
            pos[1] += map.get(ch)[1];
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
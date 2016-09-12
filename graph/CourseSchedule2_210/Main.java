package LeetCode.graph.CourseSchedule2_210;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre = new int[][]{{1,0}};
        int[] result = s.findOrder1(2, pre);
        for (int i : result) System.out.print(i + ", ");
    }
}



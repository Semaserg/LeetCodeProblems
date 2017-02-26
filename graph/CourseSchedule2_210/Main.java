package LeetCode.graph.CourseSchedule2_210;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] result = s.findOrder(4, pre);
        for (int i : result) System.out.print(i + ", ");
    }
}



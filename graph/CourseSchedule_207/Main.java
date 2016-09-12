package LeetCode.graph.CourseSchedule_207;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre = new int[][]{{1,2}, {2,1}};
        boolean result = s.canFinish1(3, pre);
        System.out.println(result);
    }
}



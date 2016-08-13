package LeetCode.dynamic.UniquePaths2_63;

public class Main {
    public static void main(String[] args) {
        Solution n = new Solution();
        int result = n.uniquePathsWithObstacles(new int [][] {{0,0,0}, {0,1,0}, {0,0,0}});
        System.out.println(result);
    }
}



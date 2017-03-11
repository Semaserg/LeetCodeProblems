package LeetCode.math.LineReflection_356;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{
                {1,1}, {-1,1}
        };
        boolean result = s.isReflected(points) ;
        System.out.println(result);
    }
}
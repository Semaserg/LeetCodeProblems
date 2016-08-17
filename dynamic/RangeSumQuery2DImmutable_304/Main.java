package LeetCode.dynamic.RangeSumQuery2DImmutable_304;

public class Main {
    public static void main(String[] args) {
        NumMatrix n = new NumMatrix(new int[][] {{3,0,1}, {2,0,1}, {1,1,1}});
        int result = n.sumRegion(0,0,2,2);
        System.out.print(result);
    }
}



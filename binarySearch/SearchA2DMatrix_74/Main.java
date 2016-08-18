package LeetCode.binarySearch.SearchA2DMatrix_74;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //boolean result = s.searchMatrix(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, 5);
        boolean result = s.searchMatrix(new int[][]{{1}}, 1);
        System.out.println(result);
    }
}
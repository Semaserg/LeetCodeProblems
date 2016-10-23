package LeetCode.binarySearch.SearchA2DMatrix2_240;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]
               {{3, 3, 8, 13,13,18},
                {4, 5, 11,13,18,20},
                {9, 9, 14,15,23,23},
                {13,18,22,22,25,27},
                {18,22,23,28,30,33},
                {21,25,28,30,35,35},
                {24,25,33,36,37,40}};
        boolean result = s.searchMatrix(matrix, 21);
        System.out.println(result);
    }
}
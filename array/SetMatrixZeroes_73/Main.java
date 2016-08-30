package LeetCode.array.SetMatrixZeroes_73;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] matrix = {
//                {1,1,1,1,1},
//                {1,1,0,1,1},
//                {1,1,1,1,0},
//                {0,1,1,1,0}
//        };
        int[][] matrix = {{0,1}};
        s.setZeroes(matrix);
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}



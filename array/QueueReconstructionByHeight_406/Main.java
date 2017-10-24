package LeetCode.array.QueueReconstructionByHeight_406;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] r = s.reconstructQueue(a);
        for (int[] p : r) {
            System.out.print(p[0] + "-" + p[1] + "; ");
        }
    }
}



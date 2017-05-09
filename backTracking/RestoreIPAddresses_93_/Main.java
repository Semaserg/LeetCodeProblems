package LeetCode.backTracking.RestoreIPAddresses_93_;

import LeetCode.backTracking.SudokuSolver_37.Solution1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.restoreIpAddresses("127001");

        for (String ip : res) {
            System.out.println(ip);
        }
    }
}


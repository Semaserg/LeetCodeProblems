package LeetCode.backTracking.RestoreIPAddresses_93_;

import java.util.*;

/*
93. Restore IP Addresses
https://leetcode.com/problems/restore-ip-addresses/#/description

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null) return result;
        backtrack(0, new ArrayList<>(), s);
        return result;
    }

    private void backtrack(int index, List<String> current, String s) {
        if (current.size() == 4) {
            if (index == s.length()) {
                String ip = String.join(".", current);
                result.add(ip);
            }
            return;
        }
        for (int i=1; i<=3; i++) {
            int nextIndex = index+i;
            if (nextIndex <= s.length()) {
                String section = s.substring(index, nextIndex);
                if (isSectionValid(section)) {
                    current.add(section);
                    backtrack(nextIndex, current, s);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    private boolean isSectionValid(String section) {
        if (section.length()== 0 || section.length()>3 ||
                (section.startsWith("0") && section.length()>1) || (Integer.valueOf(section)>=256)){
            return false;
        }
        return true;
    }
}
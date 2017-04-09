package LeetCode.string.LongestAbsoluteFilePath_388;

import java.util.ArrayList;

/*
388. Longest Absolute File Path
https://leetcode.com/problems/longest-absolute-file-path/

Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an
empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing
a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system.
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute
path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/
// https://discuss.leetcode.com/topic/55247/9-lines-4ms-java-solution
// https://discuss.leetcode.com/topic/55088/java-o-n-solution-using-stack
public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) return 0;
        String[] pathParts = input.split("\n");
        int[] lenStack = new int[pathParts.length];
        int maxPathLen = 0;
        for (String part : pathParts) {
            // assume that "\t" is only on the beginning of the path part.
            int level = part.lastIndexOf("\t")+1;// level == 0 for root directory.
            int parentPathLen = (level == 0) ? 0 : lenStack[level-1];
            //int len = parentPathLen + part.replaceAll("\t", "").length() + 1; // 1 - is "/"
            int len = parentPathLen + part.length() - level + 1; // 1 - is "/"
            if (part.contains(".")) {
                maxPathLen = Math.max(maxPathLen, len-1); //-1 beacuse we don't need last "/"
            } else {
                lenStack[level] = len;
            }
        }
        return maxPathLen;
    }

    // my stupid solution
    public int lengthLongestPath1(String input) {
        input = input.replaceAll("    ", "\t");
        if (input == null || input.isEmpty()) return 0;
        // contains cascade length, for instance:
        // dir - 3
        // dir\n\tsubdir1 - 3+7=10 and so on
        // files should not be included to this list
        ArrayList<Integer> len = new ArrayList<>();
        //ArrayList<String> debugStrs = new ArrayList<>();
        String[] parts = input.split("\n");
        int maxFilePathLen = 0;

        // add root directory
        len.add(parts[0].length());
        if (parts.length == 1 && parts[0].contains(".")) {
            return parts[0].length();
        }
        //debugStrs.add(parts[0]);
        int shift = 0;
        for (int i=1; i<parts.length; i++) {
            String current = parts[i];
            int nextShift = current.split("\t").length-1;
            int partLen = current.trim().length() + 1;
            // one level dipper
            if (nextShift>shift) {
                int parentDirLen = len.get(shift);
                //String parentDir = debugStrs.get(shift);
                int currentPathLen = parentDirLen + partLen;
                //String currentPath = parentDir + current;
                // if file
                if (current.contains(".")) {
                    if (currentPathLen > maxFilePathLen) maxFilePathLen = currentPathLen;
                } else {
                    len.add(currentPathLen);
                    //debugStrs.add(parentDir + current);
                    shift = nextShift;
                }
            } else {
                len = new ArrayList<>(len.subList(0, nextShift));
                //debugStrs = new ArrayList<>(debugStrs.subList(0, nextShift));
                int currentPathLen = (nextShift > 0) ? len.get(nextShift-1) + partLen : partLen;
                //String currentPath = debugStrs.get(nextShift-1) + current;
                // if file
                if (current.contains(".")) {
                    if (currentPathLen > maxFilePathLen) maxFilePathLen = currentPathLen;
                } else {
                    len.add(currentPathLen);
                    //debugStrs.add(currentPath);
                    shift = nextShift;
                }
            }
        }
        return maxFilePathLen;
    }
}
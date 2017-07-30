package LeetCode.string.ReadNCharactersGivenRead4_2CallMultipleTimes_158;

/*
https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/
158. Read N Characters Given Read4 II - Call multiple times

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

// read good solution in LeetCode book
public class Solution extends Reader4 {
    private final int PART_LEN = 4;
    private int offset = 0; // next position to be used from the remainder
    private int bufferSize = 0;
    private char[] buffer = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;

        int counter = 0;
        boolean eof = false;
        while (!eof && counter < n) {
            if (bufferSize == 0) {
                bufferSize = read4(buffer);
                eof = bufferSize < PART_LEN;
            }
            int bytesNeeded = Math.min(n-counter, bufferSize);
            System.arraycopy(buffer, offset, buf, counter, bytesNeeded);
            offset = (offset + bytesNeeded) % PART_LEN;
            counter += bytesNeeded;
            bufferSize -= bytesNeeded;
        }

        return counter;
//        int notUsedRemainder = PART_LEN - remainderOffset;
//        int counter = 0;
//
//        if (hasBufferedData) {
//            if (n < notUsedRemainder) {
//                System.arraycopy(remainder, remainderOffset, buf, 0, n);
//                remainderOffset += n;
//                return n;
//            } else {
//                System.arraycopy(remainder, remainderOffset, buf, 0, notUsedRemainder);
//                counter += notUsedRemainder;
//                remainder = new char[4];
//                remainderOffset = 0;
//                hasBufferedData = false;
//            }
//        }
//
//        while (!eof && counter < n) {
//            int wasRead = read4(remainder);
//            if (wasRead < PART_LEN) {
//                eof = true;
//            }
//            int bytesNeeded = Math.min(n - counter, wasRead);
//            System.arraycopy(remainder, 0, buf, counter, bytesNeeded);
//            counter += bytesNeeded;
//            remainderOffset = bytesNeeded;
//            hasBufferedData = (bytesNeeded < wasRead);
//        }
//        return counter;
    }
}

class Reader4 {
    public int read4(char[] buf) {
        return 3;
    }
}

package LeetCode.array.RangeModule_715;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(5,8);
        rm.queryRange(3,4);
        rm.removeRange(5, 6);
        rm.removeRange(3, 6);
        rm.addRange(1,3);
        rm.queryRange(2,3);
        rm.addRange(4,8);
        rm.queryRange(2,3);
        rm.removeRange(4,9);
    }
}

//    addRange(10, 20): null
//        removeRange(14, 16): null
//        queryRange(10, 14): true (Every number in [10, 14) is being tracked)
//        queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//        queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)

//["RangeModule","addRange","queryRange","removeRange","removeRange",  "addRange","queryRange", "addRange","queryRange","removeRange"]
//        [[],[5,8],[3,4],[5,6],[3,6],  [1,3], [2,3], [4,8],[2,3],[4,9]]
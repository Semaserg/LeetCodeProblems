package LeetCode.hashtable.TopKFrequentElements_347;

import java.util.Comparator;

/**
 * Created by Sergii on 01.09.2016.
 */
public class MyComparator implements Comparator<MyEntry> {

    @Override
    public int compare(MyEntry arg0, MyEntry arg1) {
//        if (arg0.count == arg1.count) return 0;
//        if (arg0.count > arg1.count) return -1;
//        return 1;
        return arg1.count - arg0.count;
    }
}
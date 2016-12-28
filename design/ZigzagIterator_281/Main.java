package LeetCode.design.ZigzagIterator_281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,3,5,7,9));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2,4,6,8));
        ZigzagIterator iterator = new ZigzagIterator(l1, l2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}



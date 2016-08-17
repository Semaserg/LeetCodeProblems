package LeetCode.stack.FlattenNestedListIterator_341;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next());
        }
    }
}

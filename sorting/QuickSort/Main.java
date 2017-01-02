package LeetCode.sorting.QuickSort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergii on 01.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,4,2,5,6,4,0,7,8,9,1,2,3,7,6,8};
        List<Integer> list = Arrays.asList(array);
        QuickSort.sort(list);
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(array);
        int el = QuickSelection.getKthElement(list1, 3);
        System.out.println(el);
    }
}

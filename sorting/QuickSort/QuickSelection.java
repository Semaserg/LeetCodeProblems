package LeetCode.sorting.QuickSort;

import java.util.Collections;
import java.util.List;

/**
 * Quick selection problem: find Kth element in array.
 */
public class QuickSelection {
    private static void exch(List<Integer> list, int indexA, int indexB) {
        int temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

    private static int partition(List<Integer> list, int lo, int hi) {
        int pivot = list.get(lo);
        int i = lo+1;
        int j = hi;
        while (true) {
            while (list.get(i) < pivot) {
                i++;
                if(i >= hi) break;
            }

            while (list.get(j) > pivot) {
                j--;
                if(j <= lo) break;
            }

            if (i >= j) break;
            QuickSelection.exch(list, i, j);
        }
        QuickSelection.exch(list, lo, j);
        return j;
    }

    public static int getKthElement(List<Integer> list, int k) {
        Collections.shuffle(list);
        int lo = 0, hi = list.size()-1;
        while (lo <= hi) {
            int pivot = QuickSelection.partition(list, lo, hi);
            if (pivot == k) return list.get(pivot);
            else if (pivot < k) lo = pivot+1;
            else if (pivot > k) hi = pivot-1;
        }
        return list.get(k); // array is fully sorted
    }
}

package LeetCode.sorting.QuickSort;

import java.util.Collections;
import java.util.List;

/**
 * Quick sort implementation for the List of integers
 */
public class QuickSort {
    private static void exch(List<Integer> list, int indexA, int indexB) {
        int temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

    private static int partition(List<Integer> list, int lo, int hi) {

        int pivot = list.get(lo);
        int i = lo + 1; // +1 brecause we going to use 0th element like a pivot.
        int j = hi;
        while (true) {
            // find item on left to swap
            while (list.get(i) < pivot) {
                i++;
                if (i == hi) break;
            }

            // find item on right to swap
            while (list.get(j) > pivot) {
                j--;
                if (j == lo) break;
            }

            // check if pointers cross
            if (i >= j) break;

            // swap
            QuickSort.exch(list, i, j);
        }
        // swap pivot with the middle element
        QuickSort.exch(list, lo, j);
        return j;
    }

    private static void sortHelper(List<Integer> list, int lo, int hi) {
        if (lo >= hi) return;
        int pivotIndex = partition(list, lo, hi);
        sortHelper(list, lo, pivotIndex-1);
        sortHelper(list, pivotIndex+1, hi);
    }

    public static void sort(List<Integer> list) {
        Collections.shuffle(list);
        sortHelper(list, 0, list.size()-1);
    }
}

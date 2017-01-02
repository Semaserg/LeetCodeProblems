package LeetCode.sorting.QuickSort;

import java.util.List;

/**
 * Dijkstra 3-way partitioning algorithm.
 * https://www.quora.com/How-does-your-3-way-quicksort-algorithm-work
 */
public class ThreeWayPartitioning {
    private static void exch(List<Integer> list, int indexA, int indexB) {
        int temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

    private static void sortHelper(List<Integer> list, int lowerBound , int upperBound) {
        if (upperBound <= lowerBound) return;
        int lt = lowerBound, gt = upperBound, i = lowerBound;
        int pivot = list.get(lowerBound);
        while (i <= gt) {
            int curr = list.get(i);
            if (curr < pivot) {
                exch(list, i, lt);
                lt++;
                i++;
            } else if (curr > pivot) {
                exch(list, i, gt);
                gt--; // do not increment i, we need to check new list[i] first.
            } else {
                i++;
            }
        }
        ThreeWayPartitioning.sortHelper(list, lowerBound, lt-1);
        ThreeWayPartitioning.sortHelper(list, gt+1, upperBound);
    }

    public static void sort(List<Integer> list) {
        ThreeWayPartitioning.sortHelper(list, 0, list.size()-1);
    }
}

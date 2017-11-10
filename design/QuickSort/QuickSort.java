package LeetCode.design.QuickSort;

public class QuickSort{
    public static void sort(Comparable[] array) {
        if (array == null) throw new IllegalStateException("ex");
        sortArray(array, 0, array.length-1);
    }

    private static void sortArray(Comparable[] array, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(array, lo, hi);
            sortArray(array, lo, pivot-1);
            sortArray(array, pivot+1, hi);
        }
    }
    private static int partition(Comparable[] array, int lo, int hi) {
        Comparable pivot = array[hi];
        int i = lo;
        for (int j=lo; j<hi; j++) {
            if (array[j].compareTo(pivot) <= 0) { //array[j] <= pivot
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, hi);
        return i;
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

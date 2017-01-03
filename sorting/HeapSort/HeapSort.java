package LeetCode.sorting.HeapSort;

/**
 * Heap sort implementation.
 * Has some bugs.
 */
public class HeapSort {
    public static void sort(int[] array) {
        int N = array.length;
        for (int i=N/2; i >=1; i--){
            sink(array, i, N);
        }
        while (N>1) {
            exch(array, 1, N);
            N--;
            sink(array, 1, N);
        }
    }

    private static void sink(int[] array, int index, int N) {
        while (2 * index <= N) {
            int leftChild = get(array, 2 * index);
            int rightChild = get(array, 2 * index + 1);
            int biggerChildIndex = leftChild < rightChild ? (2 * index + 1) : 2 * index;
            if (get(array, index) > get(array, biggerChildIndex)) return;
            else {
                exch(array, index, biggerChildIndex);
                index = biggerChildIndex;
            }
        }
    }

    private static void exch(int[] array, int i, int j) {
        int temp = get(array, i);
        set(array, i, get(array, j));
        set(array, j, temp);
    }

    // We need next 2 methods because we start array from 0, not from 1 like in the heap implementation
    private static int get(int[] array, int i) {
        if (i-1 >= array.length) return Integer.MIN_VALUE;
        return array[i-1];
    }

    private static void set(int[] array, int i, int value) {
        array[i-1] = value;
    }
}

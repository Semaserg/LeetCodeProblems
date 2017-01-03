package LeetCode.sorting.HeapSort;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,4,2,5,6,4,0,7,8,9,1,2,3,7,6,8};
        HeapSort.sort(array);
        for(int i : array) System.out.println(i);
    }
}

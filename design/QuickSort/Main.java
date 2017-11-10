package LeetCode.design.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0,1,9,2,8,3,7,4,4,4,4,4,5,6};
        //Integer[] arr = new Integer[]{};
        System.out.println(QuickSort.select(arr, 6));
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}



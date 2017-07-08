package LeetCode.array.ShortestUnsortedContinuousSubarray_581;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{2,6,4,8,10,9,15};
        int res = s.findUnsortedSubarray(arr);
        System.out.println(res);
    }
}



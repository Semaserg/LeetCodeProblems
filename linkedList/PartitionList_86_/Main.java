package LeetCode.linkedList.PartitionList_86_;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        a.next = b;
        Solution s = new Solution();
        ListNode result = s.partition(a, 2);
        System.out.print(result);
    }
}

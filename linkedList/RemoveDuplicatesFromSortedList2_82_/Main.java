package LeetCode.linkedList.RemoveDuplicatesFromSortedList2_82_;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        a.next = b;
        Solution s = new Solution();
        ListNode result = s.deleteDuplicates(a);
        System.out.print(result);
    }
}

package linkedlist;

public class PairSum {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while(slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maximumSum = 0;
        while(prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);

            prev = prev.next;
            start = start.next;
        }
        return maximumSum;
    }

    /**
     * func pairSum(head *ListNode) int {
     *     slow := head
     *     fast := head
     *
     *     for fast != nil && fast.Next != nil {
     *         slow = slow.Next
     *         fast = fast.Next.Next
     *     }
     *
     *
     *     var prev *ListNode
     *     for slow != nil {
     *         nextNode := slow.Next
     *         slow.Next = prev
     *         prev = slow
     *         slow = nextNode
     *     }
     *
     *
     *     start := head
     *     maximumSum := 0
     *     for prev != nil {
     *         if start.Val + prev.Val > maximumSum {
     *             maximumSum = start.Val + prev.Val;
     *         }
     *         prev = prev.Next
     *         start = start.Next
     *     }
     *     return maximumSum
     * }
     */

    /**
     *     def pairSum(self, head: Optional[ListNode]) -> int:
     *         slow = head
     *         fast = head
     *
     *         while fast is not None and fast.next is not None:
     *             slow = slow.next
     *             fast = fast.next.next
     *
     *         prev = None
     *
     *         while slow is not None:
     *             nextNode = slow.next
     *             slow.next = prev
     *             prev = slow
     *             slow = nextNode
     *
     *         start = head
     *         maximumSum = 0
     *
     *         while prev is not None:
     *             maximumSum = max(maximumSum, start.val + prev.val)
     *
     *             prev = prev.next
     *             start = start.next
     *
     *         return maximumSum
     */


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

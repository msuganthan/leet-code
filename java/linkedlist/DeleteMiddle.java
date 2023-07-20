package linkedlist;

public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     *     def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
     *         if head.next is None:
     *             return None
     *
     *         slow = head
     *         fast = head.next.next
     *
     *         while fast is not None and fast.next is not None:
     *             slow = slow.next
     *             fast = fast.next.next
     *
     *         slow.next = slow.next.next
     *
     *         return head
     */

    /**
     * func deleteMiddle(head *ListNode) *ListNode {
     *     if head.Next == nil {
     *         return nil
     *     }
     *     slow := head
     *     fast := head.Next.Next
     *     for fast != nil && fast.Next != nil {
     *         slow = slow.Next
     *         fast = fast.Next.Next
     *     }
     *     slow.Next = slow.Next.Next
     *     return head
     *
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

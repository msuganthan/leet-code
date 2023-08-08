package linkedlist;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /**
     *     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
     *         a = headA
     *         b = headB
     *         while a is not b:
     *             a = headB if a is None else a.next
     *             b = headA if b is None else b.next
     *
     *         return a
     */

    /**
     * func getIntersectionNode(headA, headB *ListNode) *ListNode {
     *     a := headA
     *     b := headB
     *     for a != b {
     *         if a == nil {
     *             a = headB
     *         } else {
     *             a = a.Next
     *         }
     *
     *         if b == nil {
     *             b = headA
     *         } else {
     *             b = b.Next
     *         }
     *     }
     *     return a
     * }
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

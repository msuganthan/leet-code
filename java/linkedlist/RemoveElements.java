package linkedlist;

public class RemoveElements {

    public static void main(String[] args) {
        ListNode listNode6_6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5, listNode6_6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode6 = new ListNode(6, listNode3);
        ListNode listNode2 = new ListNode(2, listNode6);
        ListNode listNode1 = new ListNode(1, listNode2);
        removeElements(listNode1, 6);
    }

    static ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode fakeHead = prev;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }

    /**
     *     def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
     *         fakeHead = ListNode(-1)
     *         fakeHead.next = head
     *         current, prev = head, fakeHead
     *
     *         while current:
     *             if current.val == val:
     *                 prev.next = current.next
     *             else:
     *                 prev = prev.next
     *
     *             current = current.next
     *
     *         return fakeHead.next`
     */

    /**
     * func removeElements(head *ListNode, val int) *ListNode {
     *     fakeHead := &ListNode{Val: -1}
     *     fakeHead.Next = head
     *     current, prev := head, fakeHead
     *
     *     for current != nil {
     *         if current.Val == val {
     *             prev.Next = current.Next
     *         } else {
     *             prev = prev.Next
     *         }
     *         current = current.Next
     *     }
     *
     *     return fakeHead.Next
     * }
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}

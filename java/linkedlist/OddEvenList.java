package linkedlist;

public class OddEvenList {

    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(7);
        ListNode listNode4 = new ListNode(4, listNode7);
        ListNode listNode6 = new ListNode(6, listNode4);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode3 = new ListNode(3, listNode5);
        ListNode listNode1 = new ListNode(1, listNode3);
        ListNode listNode2 = new ListNode(2, listNode1);

        oddEvenList(listNode2);

        while (listNode2 != null) {
            System.out.println(listNode2.val);
            listNode2 = listNode1.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode dummySecond = second;

        while (second != null && second.next != null) {
            ListNode temp = first.next.next;
            first.next = first.next.next;
            first = temp;

            ListNode temp1 = second.next.next;
            second.next = second.next.next;
            second = temp1;
        }
        first.next = dummySecond;
        return head;
    }

    /**
     * class Solution:
     *     def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
     *         if head is None:
     *             return None
     *
     *         first = head
     *         second = head.next
     *         dummySecond = second
     *
     *         while second is not None and second.next is not None:
     *             temp = first.next.next
     *             first.next = first.next.next
     *             first = temp
     *
     *             temp = second.next.next
     *             second.next = second.next.next
     *             second = temp
     *
     *         first.next = dummySecond
     *         return head
     */

    /**
     * func oddEvenList(head *ListNode) *ListNode {
     *     if head == nil {
     *         return nil
     *     }
     *
     *     first := head
     *     second := head.Next
     *     dummySecond := second
     *
     *     for second != nil && second.Next != nil {
     *         temp := first.Next.Next
     *         first.Next = first.Next.Next
     *         first = temp
     *
     *         temp = second.Next.Next
     *         second.Next = second.Next.Next
     *         second = temp
     *     }
     *
     *
     *     first.Next = dummySecond
     *     return head
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     '}';
         }
     }
}

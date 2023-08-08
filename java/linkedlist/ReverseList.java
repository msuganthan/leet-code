package linkedlist;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode list = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return list;
    }

    /**
     *     def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
     *         prev = None
     *         curr = head
     *         while curr is not None:
     *             temp = curr.next
     *             curr.next = prev
     *             prev = curr
     *             curr = temp
     *
     *         return prev
     */

    /**
     *     var prev *ListNode
     *     curr := head
     *
     *     for curr != nil {
     *         temp := curr.Next
     *         curr.Next = prev
     *         prev = curr
     *         curr = temp
     *     }
     *
     *     return prev
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

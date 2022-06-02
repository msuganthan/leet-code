package linkedList;

/**
 *  Reverse Nodes in k-Group
 *
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode begin = dummyHead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode next, first;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        begin.next = prev;
        first.next = curr;
        return first;
    }

    private class ListNode {
         int val;
         ListNode next;
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}

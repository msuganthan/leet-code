package linkedlist;

/**
 * 876. Middle of the Linked List
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     *         slow = head
     *         fast = head
     *         while fast and fast.next:
     *             slow = slow.next
     *             fast = fast.next.next
     *         return slow
     */

    /**
     * func middleNode(head *ListNode) *ListNode {
     *     slow := head
     *     fast := head
     *     for fast != nil && fast.Next != nil {
     *         slow = slow.Next
     *         fast = fast.Next.Next
     *     }
     *     return slow
     * }
     */

    private class ListNode {
        int val;
        ListNode next;
    }
}

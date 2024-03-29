package linkedlist;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 *
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the
 * linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    /**
     *     def getDecimalValue(self, head: ListNode) -> int:
     *         num = head.val
     *         while head.next is not None:
     *             num = num * 2 + head.next.val
     *             head = head.next
     *         return num
     */

    /**
     * func getDecimalValue(head *ListNode) int {
     *     num := head.Val
     *     for head.Next != nil {
     *         num = num * 2 + head.Next.Val
     *         head = head.Next;
     *     }
     *     return num
     * }
     */

    private static class ListNode {
        int val;
        ListNode next;
    }
}

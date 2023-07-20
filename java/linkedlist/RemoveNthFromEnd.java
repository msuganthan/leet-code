package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reference = head;
        List<ListNode> nodes = new ArrayList<>();
        while (reference != null) {
            nodes.add(reference);
            reference = reference.next;
        }

        if (n == nodes.size()) {
            return head.next;
        }

        int indexToRemove = nodes.size() - n;
        ListNode prev = nodes.get(indexToRemove - 1);
        prev.next = prev.next.next;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

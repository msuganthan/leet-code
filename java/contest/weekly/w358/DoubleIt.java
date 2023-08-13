package contest.weekly.w358;

/**
 * 2816. Double a Number Represented as a Linked List
 *
 * You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
 *
 * Return the head of the linked list after doubling it.
 */
public class DoubleIt {

    public ListNode doubleIt(ListNode head) {
        if(head.val > 4) {
            head = new ListNode(0, head);
        }
        for(ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if(node.next != null && node.next.val > 4) {
                node.val++;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



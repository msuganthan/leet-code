package linkedlist;

/**
 * 2181. Merge Nodes in Between Zeros
 *
 * You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
 *
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
 *
 * Return the head of the modified linked list.
 */
public class MergeNodes {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode answer = dummy;
        int sum = 0;
        while(head != null) {
            sum += head.val;
            if(head.next != null && head.next.val == 0) {
                dummy.next = new ListNode(sum);
                dummy = dummy.next;
                sum = 0;
            }
            head = head.next;
        }
        return answer.next;
    }

    /**
     *    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
     *         dummy = ListNode(0)
     *         answer = dummy
     *         sum = 0
     *         while head:
     *             sum += head.val
     *             if head.next and head.next.val == 0:
     *                 dummy.next = ListNode(sum)
     *                 dummy = dummy.next
     *                 sum = 0
     *             head = head.next
     *         return answer.next
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

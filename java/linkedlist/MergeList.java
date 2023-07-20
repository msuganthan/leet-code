package linkedlist;

/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeList {

    public static void main(String[] args) {
        //ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode1 = new ListNode(-9, listNode2);

        //ListNode listNode14 = new ListNode(4);
        ListNode listNode13 = new ListNode(7);
        ListNode listNode11 = new ListNode(5, listNode13);

        mergeTwoLists(listNode1, listNode11);
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode result = head;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;
        return result.next;
    }

    /**
     *     def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
     *         head = ListNode(0)
     *         result = head
     *         while list1 is not None and list2 is not None:
     *             if list1.val < list2.val:
     *                 head.next = ListNode(list1.val)
     *                 list1 = list1.next
     *             else:
     *                 head.next = ListNode(list2.val)
     *                 list2 = list2.next
     *             head = head.next
     *
     *         head.next = list1 if list1 is not None else list2
     *         return result.next;
     */

    /**
     * func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
     *     head := &ListNode{Val: 0}
     *     result := head
     *
     *     for list1 != nil && list2 != nil {
     *         if list1.Val < list2.Val {
     *             head.Next = &ListNode{Val: list1.Val}
     *             list1 = list1.Next
     *         } else {
     *             head.Next = &ListNode{Val: list2.Val}
     *             list2 = list2.Next
     *         }
     *         head = head.Next
     *     }
     *
     *     if list1 != nil {
     *         head.Next = list1
     *     } else {
     *         head.Next = list2
     *     }
     *
     *     return result.Next;
     * }
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

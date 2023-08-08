package linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class DeleteDuplicates {

    public static void main(String[] args) {

        ListNode listNode33 = new ListNode(3);
        ListNode listNode3 = new ListNode(3, listNode33);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode11 = new ListNode(1, listNode2);
        ListNode listNode1 = new ListNode(1, listNode11);

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(listNode1);
    }

    ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode dummyHead = curr;
        while (curr != null) {
            ListNode temp = curr;
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            curr.next = temp.next;
            curr = temp.next;
        }
        return dummyHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

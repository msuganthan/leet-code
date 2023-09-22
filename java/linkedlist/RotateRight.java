package linkedlist;

public class RotateRight {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);
        new RotateRight().rotateRight(listNode0, 4);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPointer = dummy;
        ListNode secondPointer = dummy;
        int size = 0;
        while(firstPointer.next != null) {
            size++;
            firstPointer = firstPointer.next;
        }

        int index = size - k % size;
        while(index > 0) {
            index--;
            secondPointer = secondPointer.next;
        }
        firstPointer.next = dummy.next;
        dummy.next = secondPointer.next;
        secondPointer.next = null;
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

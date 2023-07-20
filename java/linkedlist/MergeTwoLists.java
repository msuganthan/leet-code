package linkedlist;

public class MergeTwoLists {

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }
        if (l2 != null) dummyNode.next = l2;
        if (l1 != null) dummyNode.next = l1;
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}

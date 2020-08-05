package linkedList;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        removeNthNode(listNode1, 4);
    }


    static ListNode removeNthNode(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next     = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        for (int i = 0; i <= n; i++)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
